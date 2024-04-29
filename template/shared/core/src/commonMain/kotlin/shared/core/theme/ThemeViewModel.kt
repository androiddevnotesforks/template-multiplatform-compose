@file:OptIn(ExperimentalCoroutinesApi::class)

package shared.core.theme

import shared.core.BaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull

/**
 * ViewModel responsible for managing the app theme state.
 */
class ThemeViewModel : BaseViewModel() {

    /**
     * Binds the theme state to the ViewModel.
     *
     * @param state The state of the theme to be bound.
     */
    fun onBind(state: ThemeState) {
        launchAsync("onBind") {
            state.systemDarkModeStore.asFlow()
                .filterNotNull()
                .flatMapLatest { darkMode ->
                    state.configStore.asFlow()
                        .filterNotNull()
                        .mapNotNull { Data(it, darkMode) }
                }
                .map { data ->
                    val autoDark = data.config.autoDark
                    when {
                        autoDark && !data.darkMode -> data.config.lightTheme
                        autoDark && data.darkMode -> data.config.darkTheme
                        else -> data.config.defaultTheme
                    }
                }
                .collect(state.contextStore::set)
        }
    }

    private data class Data(
        val config: ThemeConfig,
        val darkMode: Boolean
    )

}