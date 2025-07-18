# Usage

## API Interface (AuthFeature)
- `fun getAuthUser(): Flow<AuthUser?>` - Returns a Flow that emits the current authenticated user or null if not authenticated
- `fun startSignInFlow(title: String? = null)` - Initiates the sign-in flow with an optional title
- `fun startSignOutFlow()` - Initiates the sign-out flow
- `fun startSignInWithEmailFlow()` - Initiates the sign-in flow specifically with email
- `fun startSignInWithGoogleFlow()` - Initiates the sign-in flow specifically with Google

## Installation

To add the Auth Feature with Supabase implementation to your project, include the following dependencies in your module's `build.gradle.kts` file:

```kotlin
// In your commonMain dependencies
implementation(projects.feature.auth.client.api)
implementation(projects.feature.auth.client.supabase)
implementation(libs.supabase)
implementation(libs.supabase.auth)
implementation(libs.supabase.compose.auth)
```

Then, register the feature provider in your application's DI container (e.g., in AppConfig.kt):

```kotlin
// Using Koin
single<AuthFeature>(SupabaseAuthProvider.qualifier) { SupabaseAuthProvider(get<SupabaseSource>().client) }

// Add to your features list
single<List<Feature>> {
    listOf(
        // other features...
        get<AuthFeature>(SupabaseAuthProvider.qualifier),
        // other features...
    )
}
```

## Configuration
To configure the `SupabaseAuthProvider`:

Constructor Parameter | Default Value | Description
---------------------|---------------|-------------
client | *required* | The SupabaseClient instance for connecting to Supabase services

## Usage
To get an instance of the `AuthFeature` provider, use Koin's dependency injection:

```kotlin
// Get the AuthFeature instance from Koin
val authFeature: AuthFeature = get(qualifier = SupabaseAuthProvider.qualifier)

// Or inject it into your class
class YourClass(
    @Named(SupabaseAuthProvider.qualifier.value) private val authFeature: AuthFeature
)
```

Example usage:

```kotlin
// Get the current authenticated user
val userFlow = authFeature.getAuthUser()
userFlow.collect { user ->
    if (user != null) {
        // User is authenticated
        println("User ID: ${user.id}")
        println("User Email: ${user.email}")
    } else {
        // User is not authenticated
    }
}

// Start the sign-in flow
authFeature.startSignInFlow("Welcome Back")

// Start the sign-in flow with email
authFeature.startSignInWithEmailFlow()

// Start the sign-in flow with Google
authFeature.startSignInWithGoogleFlow()

// Sign out
authFeature.startSignOutFlow()
```
