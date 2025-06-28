package kotli.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotli.home.presentation.HomeRoute
import kotli.home.presentation.HomeScreen
import kotli.home.presentation.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun NavGraphBuilder.home(navController: NavHostController) {
    composable<HomeRoute> { HomeScreen() }
}

val home = module {
    viewModelOf(::HomeViewModel)
}