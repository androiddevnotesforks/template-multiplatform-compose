package kotli.template.multiplatform.compose

object Rules {

    // resources
    const val StringsXml = "*/strings.xml"
    const val IndexHtml = "*/index.html"
    const val IosConfig = "*/Config.xcconfig"
    // gradle
    const val BuildGradle = "*build.gradle.kts"
    const val SettingsGradle = "settings.gradle.kts"
    const val BuildGradleRoot = "build.gradle.kts"
    const val BuildGradleComposeApp = "composeApp/build.gradle.kts"
    const val BuildGradleSharedData = "shared/data/build.gradle.kts"
    const val BuildGradleSharedDesign = "shared/design/build.gradle.kts"

    // sources
    const val IosAppDir = "iosApp"
    const val SrcAndroidMainDir = "*/src/androidMain"
    const val SrcIosMainDir = "*/src/iosMain"
    const val SrcJsMainDir = "*/src/jsMain"
    const val SrcJvmMainDir = "*/src/jvmMain"
    const val SharedCoreDir = "shared/core"
    const val SharedDataDir = "shared/data"
    const val SharedDesignDir = "shared/design"

    // kotlin
    const val Kt = "*.kt"
    const val CommonAppMainDir = "composeApp/src/commonMain"
    const val AppKt = "${CommonAppMainDir}/kotlin/app/App.kt"
    const val AppDIKt = "${CommonAppMainDir}/kotlin/app/di/DI.kt"
    const val AppScreenKt = "${CommonAppMainDir}/kotlin/app/AppScreen.kt"
    const val AppNavigationRouterKt = "${CommonAppMainDir}/kotlin/app/AppNavigationRouter.kt"
    const val AppThemeDir = "${CommonAppMainDir}/kotlin/app/ui/theme"
    const val AppThemeViewModelKt = "${AppThemeDir}/AppThemeViewModel.kt"
    const val AppThemeProviderKt = "${AppThemeDir}/AppThemeProvider.kt"
    const val AppThemeConfigDataKt = "${AppThemeDir}/AppThemeConfigData.kt"
    const val AppThemePersistenceViewModelKt = "${AppThemeDir}/AppThemePersistenceViewModel.kt"
    const val ProvidesNavigationBarStateKt = "${CommonAppMainDir}/kotlin/app/di/state/ProvidesNavigationBarState.kt"
    const val ProvidesNavigationStateKt = "${CommonAppMainDir}/kotlin/app/di/state/ProvidesNavigationState.kt"
    const val UserFlowDir = "${CommonAppMainDir}/kotlin/app/userflow"
    const val UserFlowDataLoaderDir = "${UserFlowDir}/loader/data"
    const val UserFlowThemeDir = "${UserFlowDir}/theme"
    const val UserFlowThemeChangeDir = "${UserFlowThemeDir}/change"
    const val UserFlowThemeToggleDir = "${UserFlowThemeDir}/toggle"
    const val ShowcasesDir = "${CommonAppMainDir}/kotlin/app/showcases"
    const val ShowcasesHttpDir = "${ShowcasesDir}/datasource/http"
    const val ShowcasesPagingDir = "${ShowcasesDir}/datasource/paging"
    const val ShowcasesKeyValueDir = "${ShowcasesDir}/datasource/keyvalue"
    const val ShowcasesNavigationDir = "${ShowcasesDir}/navigation"
    const val ShowcasesThemeDir = "${ShowcasesDir}/userflow/theme"
    const val ShowcasesLoaderDir = "${ShowcasesDir}/userflow/loader"
    const val ShowcasesPasscodeDir = "${ShowcasesDir}/userflow/passcode"
    const val ShowcasesKt = "${ShowcasesDir}/Showcases.kt"
    const val ThemeStateKt = "${SharedCoreDir}/src/commonMain/kotlin/shared/core/theme/ThemeState.kt"
    // dataflow
    const val AppConfigSource = "${CommonAppMainDir}/kotlin/app/datasource/config/AppConfigSource.kt"
    const val AnalyticsSource = "*/*AnalyticsSource.kt"
    const val ConfigSource = "*/*ConfigSource.kt"
    const val PagingSource = "*/*Paging*.kt"
    const val HttpSource = "*/*HttpSource.kt"
    const val KeyValueSource = "*/*KeyValueSource.kt"
    const val SettingsKeyValueSource = "*/*SettingsKeyValueSource.kt"

}