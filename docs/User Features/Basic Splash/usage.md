# Usage

## API Interface (SplashFeature)
- `fun setVisible(visible: Boolean)` - Shows or hides the splash screen

## Installation

To add the Splash Feature to your project, include the following dependencies in your module's `build.gradle.kts` file:

```kotlin
// In your commonMain dependencies
implementation(projects.feature.splash.client.api)
implementation(projects.feature.splash.client.basic)
```

Then, register the feature provider in your application's DI container (e.g., in AppConfig.kt):

```kotlin
// Using Koin
single<SplashFeature> { BasicSplashProvider() }

// Add to your features list
single<List<Feature>> {
    listOf(
        // other features...
        get<SplashFeature>(),
        // other features...
    )
}
```

## Configuration
To configure the `BasicSplashProvider`:

Constructor Parameter | Default Value | Description
---------------------|---------------|-------------
show | true | Whether the splash screen is initially visible

## Usage
To get an instance of the `SplashFeature` provider, use Koin's dependency injection:

```kotlin
// Get the SplashFeature instance from Koin
val splashFeature: SplashFeature = get()

// Or inject it into your class
class YourClass(private val splashFeature: SplashFeature)
```

Example usage:

```kotlin
// Show the splash screen
splashFeature.setVisible(true)

// Hide the splash screen
splashFeature.setVisible(false)

// Show the splash screen for 2 seconds and then hide it
coroutineScope.launch {
    splashFeature.setVisible(true)
    delay(2000)
    splashFeature.setVisible(false)
}
```
