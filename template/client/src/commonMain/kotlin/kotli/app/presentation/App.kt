package kotli.app.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import feature.common.api.FeatureHost
import feature.common.api.FeatureHostContext
import kotli.app.app
import kotli.getViewModel

@Composable
fun App() {
    val viewModel: AppViewModel = getViewModel()
    val state = viewModel.state

    val context = FeatureHostContext(
        navController = rememberNavController(),
        features = state.features,
        debug = true
    )

    FeatureHost(
        context = context,
        navGraphBuilder = { app(it) },
        startDestinationProvider = state::start::get,
    )
}
