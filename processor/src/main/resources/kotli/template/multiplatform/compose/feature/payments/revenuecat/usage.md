## API Interface (PaymentsFeature)
- `fun showPaywall()` - Shows the paywall for in-app purchases and subscriptions

## Installation

To add the Payments Feature to your project, include the following dependencies in your module's `build.gradle.kts` file:

```kotlin
// In your commonMain dependencies
implementation(projects.feature.payments.client.api)
implementation(projects.feature.payments.client.revenuecat)
```

Then, register the feature provider in your application's DI container (e.g., in AppConfig.kt):

```kotlin
// Using Koin
single<PaymentsFeature> { RevenueCatPaymentsProvider() }

// Add to your features list
single<List<Feature>> {
    listOf(
        // other features...
        get<PaymentsFeature>(),
        // other features...
    )
}
```

## Configuration
The `RevenueCatPaymentsProvider` doesn't require any configuration parameters.

> **Note:** The current implementation is a placeholder. The `showPaywall()` method is not yet implemented.

## Usage
To get an instance of the `PaymentsFeature` provider, use Koin's dependency injection:

```kotlin
// Get the PaymentsFeature instance from Koin
val paymentsFeature: PaymentsFeature = get()

// Or inject it into your class
class YourClass(private val paymentsFeature: PaymentsFeature)
```

Example usage:

```kotlin
// Show the paywall
paymentsFeature.showPaywall()
```