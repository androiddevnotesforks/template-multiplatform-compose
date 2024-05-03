## Overview

- Component package: `app.ui.theme`
- State management: `shared.core.theme.ThemeState`
- DI integration: `app.di.state.ProvidesThemeState`

This state instance is utilized by `app.ui.theme.AppThemeProvider`, which is pre-defined at the app level to furnish themes for the entire application.

```kotlin
@Composable
fun App() = ViewModelProvider(remember { AppViewModelFactory }) { 
    AppThemeProvider {
        AppScreen()
    }
}
```

## Change Themes

By default, `ThemeState` is initialized with pre-defined dark and light themes in the `design` module. To edit these themes:

1. Visit the [Material 3 Theme Builder](https://m3.material.io/theme-builder#/custom).
2. Customize the desired color theme.
3. Click on the **Export** button and confirm exporting as **Jetpack Compose (Theme.kt)**.
4. Paste the exported files (**Theme.kt** and **Color.kt**) into the package `shared.design.theme` of the `design` module and update their package declaration accordingly.
5. In the `Theme.kt` file add the following snippet:
   ```kotlin
   val LightThemeContext = AppTheme(
    dark = false,
    id = "material_3_light",
    colorScheme = LightColors
   )

   val DarkThemeContext = AppTheme(
    dark = true,
    id = "material_3_dark",
    colorScheme = DarkColors
   )
   ```

The themes can be declared directly in the app module. However, if you plan to use feature modules, it might be beneficial to declare the theme in the `design` module.