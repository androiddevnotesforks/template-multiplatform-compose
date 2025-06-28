# Usage

## API Interface (LoaderFeature)
- `suspend fun runLoading(title: String, block: suspend () -> Unit)` - Runs a loading operation with a title, displaying a blocking UI state while the operation is in progress

## Installation

To add the Loader Feature to your project, include the following dependencies in your module's `build.gradle.kts` file:

```kotlin
// In your commonMain dependencies
implementation(projects.feature.loader.client.api)
implementation(projects.feature.loader.client.basic)
```

Then, register the feature provider in your application's DI container (e.g., in AppConfig.kt):

```kotlin
// Using Koin
single<LoaderFeature> { BasicLoaderProvider() }

// Add to your features list
single<List<Feature>> {
    listOf(
        // other features...
        get<LoaderFeature>(),
        // other features...
    )
}
```

## Configuration
The `BasicLoaderProvider` doesn't require any configuration parameters.

## Usage
To get an instance of the `LoaderFeature` provider, use Koin's dependency injection:

```kotlin
// Get the LoaderFeature instance from Koin
val loaderFeature: LoaderFeature = get()

// Or inject it into your class
class YourClass(private val loaderFeature: LoaderFeature)
```

Example usage:

```kotlin
// Run a loading operation with a title
loaderFeature.runLoading("Loading data...") {
    // Your asynchronous operation here
    delay(1000)
    fetchData()
}

// The UI will show a blocking state with the title "Loading data..."
// while the operation is in progress
```
