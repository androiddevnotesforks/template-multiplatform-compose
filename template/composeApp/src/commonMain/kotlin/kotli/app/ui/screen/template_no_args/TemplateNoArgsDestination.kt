package kotli.app.ui.screen.template_no_args

import androidx.navigation.NavGraphBuilder
import shared.core.navigation.NavigationDestinationNoArgs
import shared.core.navigation.NavigationStrategy

object TemplateNoArgsDestination : NavigationDestinationNoArgs() {

    override val id: String = "template_no_args_screen"
    override val navStrategy: NavigationStrategy = NavigationStrategy.NewInstance
    override fun doBind(builder: NavGraphBuilder) = composable(builder) { TemplateNoArgsScreen() }

}