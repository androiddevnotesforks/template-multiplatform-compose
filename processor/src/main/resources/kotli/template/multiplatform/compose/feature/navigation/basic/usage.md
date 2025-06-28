## API Interface (NavigationFeature)
- `fun setItems(vararg items: NavigationItem)` - Sets the navigation items
- `fun setType(type: NavigationType)` - Sets the navigation type
- `fun getType(): NavigationType` - Gets the current navigation type
- `fun setVisible(visible: Boolean)` - Shows or hides the navigation
- `fun isVisible(): Boolean` - Checks if the navigation is visible

## Installation

To add the Navigation Feature to your project, include the following dependencies in your module's `build.gradle.kts` file:

```kotlin
// In your commonMain dependencies
implementation(projects.feature.navigation.client.api)
implementation(projects.feature.navigation.client.basic)
```

Then, register the feature provider in your application's DI container (e.g., in AppConfig.kt):

```kotlin
// Using Koin
single<NavigationFeature> { BasicNavigationProvider() }

// Add to your features list
single<List<Feature>> {
    listOf(
        // other features...
        get<NavigationFeature>(),
        // other features...
    )
}
```

## Configuration
To configure the `BasicNavigationProvider`:

Constructor Parameter | Default Value | Description
---------------------|---------------|-------------
type | NavigationType.Adaptive | The type of navigation to use
items | null | The initial navigation items to display

## Usage
To get an instance of the `NavigationFeature` provider, use Koin's dependency injection:

```kotlin
// Get the NavigationFeature instance from Koin
val navigationFeature: NavigationFeature = get()

// Or inject it into your class
class YourClass(private val navigationFeature: NavigationFeature)
```

Example usage:

```kotlin
// Set navigation items
navigationFeature.setItems(
    NavigationItem(
        route = "home",
        activeIcon = DsIconModel.fromImageVector(Icons.Default.Home),
        label = "Home"
    ),
    NavigationItem(
        route = "settings",
        activeIcon = DsIconModel.fromImageVector(Icons.Default.Settings),
        label = "Settings"
    )
)

// Set navigation type
navigationFeature.setType(NavigationType.Bottom)

// Show navigation
navigationFeature.setVisible(true)

// Check if navigation is visible
val isVisible = navigationFeature.isVisible()

// Get current navigation type
val type = navigationFeature.getType()
```

### NavigationItem Properties

Property | Default Value | Description
---------|---------------|-------------
route | *required* | The route for the navigation item
activeIcon | *required* | The icon to display when the item is active
inactiveIcon | activeIcon | The icon to display when the item is inactive
showLabel | true | Whether to show the label
enabled | true | Whether the item is enabled
label | null | The label text

### NavigationType Options

- `Adaptive` - Adapts to the screen size
- `Bottom` - Bottom navigation
- `Dismissable` - Dismissable navigation
- `Modal` - Modal navigation
- `Permanent` - Permanent navigation
- `Rail` - Rail navigation