package app

import shared.core.BaseViewModel
import shared.core.navigation.NavigationState

class AppViewModel(
    private val navigationRouter: AppNavigationRouter,
    val navigationState: NavigationState,
    val appState: AppState
) : BaseViewModel() {

    override fun doBind() {
        launchAsync("doBind") {
            val startDestination = navigationRouter.getStartDestination()
            navigationState.setStartDestination(startDestination)
        }
    }

}