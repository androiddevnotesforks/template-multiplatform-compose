package kotli.app.presentation_no_features

import kotli.home.presentation.HomeRoute
import shared.presentation.theme.ThemeState
import shared.presentation.viewmodel.BaseViewModel

class AppViewModel(
    val state: AppState,
    val themeState: ThemeState
) : BaseViewModel() {

    override fun doBind() {
        withState {
            themeState.currentConfig = themeState.defaultConfig
            state.setStartDestination(HomeRoute)
        }
    }
}