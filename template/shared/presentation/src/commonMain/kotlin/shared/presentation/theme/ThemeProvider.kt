package shared.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.ui.text.font.FontFamily
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull

@Composable
fun ThemeProvider(
    state: ThemeState,
    content: @Composable () -> Unit
) {
    LaunchedEffect(state) {
        val systemDarkModeFlow = snapshotFlow { state.systemDarkMode }.filterNotNull()
        val currentConfigFlow = snapshotFlow { state.currentConfig }.filterNotNull()

        combine(systemDarkModeFlow, currentConfigFlow) { darkMode, config ->
            val autoDark = config.autoDark
            val theme = when {
                autoDark && !darkMode -> config.lightTheme
                autoDark && darkMode -> config.darkTheme
                else -> config.defaultTheme
            }
            Snapshot.withMutableSnapshot {
                state.fontFamily = config.fontFamily
                state.systemDarkMode = darkMode
                state.currentConfig = config
                state.currentTheme = theme
            }
        }.collect {}
    }
    SystemDarkModeHandler(state::systemDarkMode::set)
    ThemeSwitchHandler(state, content)
}

@Composable
private fun SystemDarkModeHandler(
    onSystemDarkModeChanged: (mode: Boolean) -> Unit
) {
    val systemDarkMode = isSystemInDarkTheme()
    LaunchedEffect(systemDarkMode) {
        onSystemDarkModeChanged(systemDarkMode)
    }
}

@Composable
private fun ThemeSwitchHandler(
    state: ThemeState,
    content: @Composable () -> Unit
) {
    val theme = state.currentTheme ?: return
    CompositionLocalProvider(localTheme provides theme) {
        val fontFamily = state.fontFamily

        MaterialTheme(
            typography = remember(fontFamily) { map(fontFamily) },
            colorScheme = theme.colorScheme,
            content = content
        )
    }
}

private fun map(fontFamily: FontFamily): Typography {
    val typography = Typography()
    if (typography.bodyLarge.fontFamily != fontFamily) {
        return Typography(
            displayLarge = typography.displayLarge.copy(fontFamily = fontFamily),
            displayMedium = typography.displayMedium.copy(fontFamily = fontFamily),
            displaySmall = typography.displaySmall.copy(fontFamily = fontFamily),
            headlineLarge = typography.headlineLarge.copy(fontFamily = fontFamily),
            headlineMedium = typography.headlineMedium.copy(fontFamily = fontFamily),
            headlineSmall = typography.headlineSmall.copy(fontFamily = fontFamily),
            titleLarge = typography.titleLarge.copy(fontFamily = fontFamily),
            titleMedium = typography.titleMedium.copy(fontFamily = fontFamily),
            titleSmall = typography.titleSmall.copy(fontFamily = fontFamily),
            bodyLarge = typography.bodyLarge.copy(fontFamily = fontFamily),
            bodyMedium = typography.bodyMedium.copy(fontFamily = fontFamily),
            bodySmall = typography.bodySmall.copy(fontFamily = fontFamily),
            labelLarge = typography.labelLarge.copy(fontFamily = fontFamily),
            labelMedium = typography.labelMedium.copy(fontFamily = fontFamily),
            labelSmall = typography.labelSmall.copy(fontFamily = fontFamily)
        )
    } else {
        return typography
    }
}