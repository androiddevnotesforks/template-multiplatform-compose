package kotli.app.userflow.theme.change

import androidx.navigation.NavGraphBuilder
import shared.core.navigation.NavigationDestinationNoArgs
import shared.core.navigation.NavigationStrategy

/**
 * Navigation destination for the change theme dialog screen.
 */
object ChangeThemeDialogDestination : NavigationDestinationNoArgs() {

    override val id: String = "change_theme_dialog_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = dialog(builder) { ChangeThemeDialog() }

}