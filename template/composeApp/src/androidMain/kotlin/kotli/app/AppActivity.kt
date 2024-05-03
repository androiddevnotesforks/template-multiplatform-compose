package kotli.app

import android.graphics.Color
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen
import shared.core.misc.extensions.findActivity
import shared.core.navigation.NavigationState
import shared.core.theme.ThemeState

@Composable
private fun EdgeToEdgeHandler(state: ThemeState) {
    val activity = LocalContext.current.findActivity() ?: return
    val data = state.dataStore.asStateValue() ?: return
    val dark = data.context.dark
    val barStyle = remember(dark) {
        if (dark) {
            SystemBarStyle.dark(Color.TRANSPARENT)
        } else {
            SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT)
        }
    }
    LaunchedEffect(activity, barStyle) {
        activity.enableEdgeToEdge(
            statusBarStyle = barStyle,
            navigationBarStyle = barStyle
        )
    }
}

@Composable
private fun SplashBlock(splashScreen: SplashScreen, navigationState: NavigationState) {
    splashScreen.setKeepOnScreenCondition { navigationState.currentDestinationStore.isNull() }
}