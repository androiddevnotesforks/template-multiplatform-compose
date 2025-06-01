## API Interface (PasscodeFeature)
- `suspend fun isPasscodeSet(): Boolean` - Checks if a passcode is currently set
- `fun startSetPasscodeFlow()` - Initiates the flow to set a new passcode
- `fun startResetPasscodeFlow()` - Initiates the flow to reset an existing passcode
- `fun startForgotPasscodeFlow()` - Initiates the flow for handling a forgotten passcode

## Installation

To add the Passcode Feature to your project, include the following dependencies in your module's `build.gradle.kts` file:

```kotlin
// In your commonMain dependencies
implementation(projects.feature.passcode.client.api)
implementation(projects.feature.passcode.client.basic)
```

Then, register the feature provider in your application's DI container (e.g., in AppConfig.kt):

```kotlin
// Using Koin
single<PasscodeFeature> { BasicPasscodeProvider(get(), get()) }

// Add to your features list
single<List<Feature>> {
    listOf(
        // other features...
        get<PasscodeFeature>(),
        // other features...
    )
}
```

## Configuration
To configure the `BasicPasscodeProvider`:

Constructor Parameter | Default Value | Description
---------------------|---------------|-------------
settingsSource | *required* | Source for storing settings
encryptionSource | *required* | Source for encryption operations
passcodeLength | 4 | Length of the passcode
unlockAttemptsCount | 5 | Number of attempts allowed before locking
persistentKey | "passcode_config" | Key used for persistent storage
resumeTimeout | 3.seconds.inWholeMilliseconds | Timeout for resuming the app
encryptionMethod | EncryptionMethod::PBKDF2 | Method used for encryption

## Usage
To get an instance of the `PasscodeFeature` provider, use Koin's dependency injection:

```kotlin
// Get the PasscodeFeature instance from Koin
val passcodeFeature: PasscodeFeature = get()

// Or inject it into your class
class YourClass(private val passcodeFeature: PasscodeFeature)
```

Example usage:

```kotlin
// Check if passcode is set
val isSet = passcodeFeature.isPasscodeSet()

// Start the flow to set a new passcode
passcodeFeature.startSetPasscodeFlow()

// Start the flow to reset an existing passcode
passcodeFeature.startResetPasscodeFlow()

// Start the flow for handling a forgotten passcode
passcodeFeature.startForgotPasscodeFlow()
```