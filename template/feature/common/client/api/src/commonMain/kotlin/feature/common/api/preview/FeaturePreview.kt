package feature.common.api.preview

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import feature.common.api.FeatureHostContext
import shared.presentation.theme.DefaultThemeState
import shared.presentation.theme.ThemeConfig
import shared.presentation.theme.ThemeProvider
import shared.presentation.ui.component.DsIcon
import shared.presentation.ui.component.DsOutlinedCard
import shared.presentation.ui.component.DsSmallFloatingActionButton
import shared.presentation.ui.component.DsSpacer8
import shared.presentation.ui.component.DsText
import shared.presentation.ui.container.DsFixedTopBarLazyColumn
import shared.presentation.ui.theme.DsTheme
import shared.presentation.ui.theme.DsThemes

internal val featurePreviewVisible = mutableStateOf(false)
private val selectedPreviewState = mutableStateOf<FeaturePreviewProvider?>(null)

@Composable
fun FeaturePreviewScreen(
    previewProvider: FeaturePreviewProvider,
    modifier: Modifier = Modifier,
    onBack: (() -> Unit)? = null
) {
    val methods = remember(previewProvider) { previewProvider.getMethods() }

    ThemeContent {
        DsFixedTopBarLazyColumn(
            modifier = modifier,
            title = previewProvider.name,
            onBack = onBack
        ) {
            item { DsSpacer8() }
            methods.forEach { method -> featureMethodItem(method) }
            item { DsSpacer8() }
        }
    }
}

@Composable
fun FeaturePreviewScreen(
    title: String,
    providers: List<FeaturePreviewProvider>,
    modifier: Modifier = Modifier,
    onBack: (() -> Unit)? = null
) {
    ThemeContent {
        DsFixedTopBarLazyColumn(
            modifier = modifier,
            onBack = onBack,
            title = title,
        ) {
            item { DsSpacer8() }
            providers.forEach { feature ->
                featureItem(feature, selectedPreviewState::value::set)
            }
            item { DsSpacer8() }
        }

        selectedPreviewState.value?.let { provider ->
            FeaturePreviewScreen(
                modifier = modifier,
                previewProvider = provider,
                onBack = { selectedPreviewState.value = null }
            )
        }
    }
}

@Composable
fun FeaturePreviewScreen(context: FeatureHostContext) {
    if (!context.debug) return

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopEnd
    ) {
        if (featurePreviewVisible.value) {
            FeaturePreviewScreen(
                modifier = Modifier.fillMaxSize(),
                title = "Features",
                providers = context.features.filterIsInstance<FeaturePreviewProvider>()
            )
        }

        DsSmallFloatingActionButton(
            containerColor = Color.Red,
            contentColor = Color.White,
            modifier = Modifier
                .padding(8.dp)
                .statusBarsPadding()
                .alpha(0.8f)
            ,
            icon = FeaturePreviewIcons.debugPanel(featurePreviewVisible.value),
            onClick = { featurePreviewVisible.value = !featurePreviewVisible.value }
        )
    }
}

@Composable
private fun ThemeContent(content: @Composable () -> Unit) {
    if (DsTheme.currentOrNull == null) {
        val themeState = remember {
            DefaultThemeState(
                defaultConfig = ThemeConfig(
                    defaultTheme = DsThemes.Light,
                    lightTheme = DsThemes.Light,
                    darkTheme = DsThemes.Dark,
                )
            )
        }
        ThemeProvider(themeState) {
            content()
        }
    } else {
        content()
    }
}

private fun LazyListScope.featureItem(
    feature: FeaturePreviewProvider,
    onClick: (FeaturePreviewProvider) -> Unit
) {
    item {
        DsOutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = { onClick(feature) })
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    DsText(
                        text = feature.name,
                        color = DsTheme.current.onSurface
                    )
                    DsText(
                        text = feature.type.simpleName,
                        color = DsTheme.current.onSurfaceSecondary
                    )
                }
                DsIcon(
                    model = FeaturePreviewIcons.chevronRight,
                    tint = DsTheme.current.onSurfaceSecondary
                )
            }
        }
    }
}

private fun LazyListScope.featureMethodItem(
    featureMethod: FeatureMethod
) {
    item {
        DsOutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            featureMethod.preview()
        }
    }
}