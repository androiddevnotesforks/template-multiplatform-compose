package kotli.app.presentation

import feature.navigation.api.NavigationFeature
import feature.navigation.api.NavigationItem
import feature.splash.api.SplashFeature
import kotli.common.presentation.Icons
import kotli.home.presentation.HomeRoute
import shared.presentation.viewmodel.BaseViewModel

class AppViewModel(
    private val navigationFeature: NavigationFeature,
    private val splashFeature: SplashFeature,
    val state: AppState
) : BaseViewModel() {

    override fun doBind() {
        withState {
            // {feature.navigation.client.api}
            navigationFeature.setItems(
                NavigationItem(
                    label = "Home",
                    route = HomeRoute,
                    activeIcon = Icons.home,
                )
            )
            // {feature.navigation.client.api}
            state.setStartDestination(HomeRoute)
            splashFeature.setVisible(false)
        }
    }
}