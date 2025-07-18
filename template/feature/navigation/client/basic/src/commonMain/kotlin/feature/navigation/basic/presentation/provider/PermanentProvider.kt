package feature.navigation.basic.presentation.provider

import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import feature.navigation.basic.presentation.NavigationState
import shared.presentation.ui.container.DsPermanentNavigation

@Composable
@NonRestartableComposable
internal fun PermanentProvider(
    state: NavigationState,
    content: @Composable () -> Unit
) {
    DsPermanentNavigation(
        state = state,
        content = content
    )
}