package kotli.app

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import feature.auth.api.AuthFeature
import feature.auth.stub.StubAuthProvider
import feature.auth.supabase.SupabaseAuthProvider
import feature.common.api.Feature
import feature.loader.api.LoaderFeature
import feature.loader.basic.BasicLoaderProvider
import feature.navigation.api.NavigationFeature
import feature.navigation.basic.BasicNavigationProvider
import feature.passcode.api.PasscodeFeature
import feature.passcode.basic.BasicPasscodeProvider
import feature.payments.api.PaymentsFeature
import feature.payments.revenuecat.RevenueCatPaymentsProvider
import feature.splash.api.SplashFeature
import feature.splash.basic.BasicSplashProvider
import feature.theme.api.ThemeFeature
import feature.theme.basic.BasicThemeProvider
import kotli.app.presentation.AppMutableState
import kotli.app.presentation.AppState
import kotli.app.presentation.AppViewModel
import kotli.common.common
import kotli.common.data.source.supabase.SupabaseSource
import kotli.home.home
import kotli.platform.platform
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import shared.presentation.theme.DefaultThemeState
import shared.presentation.theme.ThemeConfig
import shared.presentation.theme.ThemeState
import shared.presentation.ui.theme.DsThemes

fun NavGraphBuilder.app(navController: NavHostController) {
    platform(navController)
    common(navController)
    home(navController)
}

val app = module {
    includes(
        platform,
        common,
        home
    )
    viewModelOf(::AppViewModel)
    singleOf(::AppMutableState).bind<AppState>()
    single<ThemeState> {
        DefaultThemeState(
            defaultConfig = ThemeConfig(
                defaultTheme = DsThemes.Light,
                lightTheme = DsThemes.Light,
                darkTheme = DsThemes.Dark,
            )
        )
    }
    single<SplashFeature> { BasicSplashProvider() }
    single<LoaderFeature> { BasicLoaderProvider() }
    single<NavigationFeature> { BasicNavigationProvider() }
    single<PaymentsFeature> { RevenueCatPaymentsProvider() }
    single<ThemeFeature> { BasicThemeProvider(get(), get()) }
    single<PasscodeFeature> { BasicPasscodeProvider(get(), get()) }
    single<AuthFeature>(SupabaseAuthProvider.qualifier) { SupabaseAuthProvider(get<SupabaseSource>().client) }
    single<AuthFeature>(StubAuthProvider.qualifier) { StubAuthProvider() }
    // {feature.common.client.api}
    single<List<Feature>> {
        listOf(
            get<SplashFeature>(),
            get<ThemeFeature>(),
            get<LoaderFeature>(),
            get<PasscodeFeature>(),
            get<NavigationFeature>(),
            get<AuthFeature>(StubAuthProvider.qualifier),
            get<AuthFeature>(SupabaseAuthProvider.qualifier),
            get<PaymentsFeature>()
        )
    }
    // {feature.common.client.api}
}