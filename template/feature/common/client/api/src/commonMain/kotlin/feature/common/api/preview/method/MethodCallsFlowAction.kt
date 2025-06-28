package feature.common.api.preview.method

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import feature.common.api.preview.FeatureMethod
import feature.common.api.preview.FeaturePreviewIcons
import feature.common.api.preview.featurePreviewVisible
import kotlinx.coroutines.launch
import shared.presentation.ui.component.DsIcon
import shared.presentation.ui.component.DsText
import shared.presentation.ui.theme.DsTheme

data class MethodCallsFlowAction(
    override val name: String,
    val action: suspend () -> Unit
) : FeatureMethod {

    @Composable
    override fun preview() {
        val scope = rememberCoroutineScope()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = {
                    scope.launch {
                        featurePreviewVisible.value = false
                        action()
                    }
                })
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DsText(text = name)
            DsIcon(
                model = FeaturePreviewIcons.chevronRight,
                tint = DsTheme.current.onSurfaceSecondary
            )
        }
    }
}