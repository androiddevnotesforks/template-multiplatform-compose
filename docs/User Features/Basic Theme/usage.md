# Usage

## API Interface (ThemeFeature)
- `fun showChangeThemeScreen()` - Shows a full screen for changing the theme
- `fun showChangeThemeDialog()` - Shows a dialog for changing the theme
- `fun showChangeThemeBottomSheet()` - Shows a bottom sheet for changing the theme
- `@Composable fun ToggleButton(modifier: Modifier = Modifier)` - Provides a composable toggle button for quick theme switching

## Installation

To add the Theme Feature to your project, include the following dependencies in your module's `build.gradle.kts` file:

```kotlin
// In your commonMain dependencies
implementation(projects.feature.theme.client.api)
implementation(projects.feature.theme.client.basic)
```

Then, register the feature provider in your application's DI container (e.g., in AppConfig.kt):

```kotlin
// Using Koin
single<ThemeFeature> { BasicThemeProvider(get(), get()) }

// Add to your features list
single<List<Feature>> {
    listOf(
        // other features...
        get<ThemeFeature>(),
        // other features...
    )
}
```

## Configuration
To configure the `BasicThemeProvider`:

Constructor Parameter | Default Value | Description
---------------------|---------------|-------------
themeState | *required* | State object for managing theme configuration
settingsSource | *required* | Source for storing theme preferences

## Usage
To get an instance of the `ThemeFeature` provider, use Koin's dependency injection:

```kotlin
// Get the ThemeFeature instance from Koin
val themeFeature: ThemeFeature = get()

// Or inject it into your class
class YourClass(private val themeFeature: ThemeFeature)
```

Example usage:

```kotlin
// Show the theme selection screen
themeFeature.showChangeThemeScreen()

// Show the theme selection dialog
themeFeature.showChangeThemeDialog()

// Show the theme selection bottom sheet
themeFeature.showChangeThemeBottomSheet()

// Use the toggle button in a composable
@Composable
fun MyScreen() {
    // ...
    themeFeature.ToggleButton()
    // ...
}
```
