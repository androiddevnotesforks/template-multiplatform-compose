# Compose Multiplatform Fully Configurable Project Template

## Supported Platforms

- Android
- iOS
- Web (JS)
- Desktop (Windows, MacOS, Linux)
- Backend (Server)

```
All target platforms are optional and will be included only if selected during configuration, along with any features.
```

## Table of Contents

- [Overview](#overview)
- [Get started](#get-started)
- [Architecture](#architecture)
- [Documentation](#documentation)
- [Showcases](#showcases)
- [How to use](#how-to-use)
- [Features](#features)

# Overview

The template follows the general principals:

- The underlying architecture is minimalistic, pre-configured, and complies with the latest recommended guidelines.
- Third-party dependencies, components, DevOps practices, and configurations are optional and can be included or excluded through an online service [Kotli](https://kotli.xyz).
- All out-of-the-box solutions work seamlessly across all supported platforms and are designed to accelerate the development of complex and production-ready applications within days, prioritizing simplicity and efficiency during the implementation and support phases.

# Get started

**!IMPORTANT!** The given template is a [Kotli Template](https://kotlitecture.github.io/engine/template_overview).

To generate the required project structure, use online service [Kotli](https://kotli.xyz/project) (it's free and only requires an internet connection).

Once you configure the necessary features and generate the archive with source codes, you'll have a ready-to-use and working project structure that can be imported into your IDE to begin adding the required business logic.

The template will also include all necessary showcases to make understanding of the included features easy.

Run your project to check what is included and how it works, and once everything is clear, remove the package with showcases and any references to it.

# Architecture

![Modules](images/concept/arch_modules.png)

## Frontend

The overall client architecture follows [the recommended guidelines](https://developer.android.com/topic/architecture/recommendations) and is built on:
- [Compose Multiplatform UI Framework](https://www.jetbrains.com/lp/compose-multiplatform/)
- [Compose Multiplatform Images and resources](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-images-resources.html)
- [Jetpack Compose](https://developer.android.com/develop/ui/compose)
- [Jetpack Navigation](https://developer.android.com/guide/navigation)
- [Jetpack Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)
- [Jetpack ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [Material 3 Design](https://m3.material.io)
- [Koin Dependency Injection](https://insert-koin.io)

Application logic is implemented in the `app` module and contains only app-specific behavior.

All common logic is part of the shared group, which is split into three modules:

- **presentation** - [Presentation Layer](https://developer.android.com/topic/architecture/ui-layer).
- **data** - [Data Layer](https://developer.android.com/topic/architecture/data-layer).
- **domain** - [Domain Layer](https://developer.android.com/topic/architecture/domain-layer).

These modules are used only at the app level. This approach lets you develop all three components independently and create a more complex app structure. For example, app-specific features can be implemented as separate modules, having the same shared dependencies.

### Module - presentation

Provides architectural solutions and design system of the app to implement user flows and integrate all components with each other in a lifecycle-aware manner.

It includes:

- **MVVM pattern implementation** - based on the [Jetpack ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) and [Jetpack Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) components.
- **Navigation integration** - based on the [Jetpack Navigation](https://developer.android.com/guide/navigation) component.
- **UI Components** - [Design System](https://en.m.wikipedia.org/wiki/Design_system) of the entire app based on the [Google Material 3 Design](https://m3.material.io).

The included solutions are not mandatory to follow, as all required dependencies are properly included to enable you to use your own patterns with Jetpack components.

However, the provided implementations are very intuitive to use and cover all possible cases of communication between components in various real-life scenarios.

Feel free to choose what fits your needs best.

### Module - data

Provides a fundamental implementation of commonly used data sources. During project setup via [Kotli](https://kotli.xyz), only the required data sources will be included.

All data sources have been configured to access the necessary data layer in a flexible and convenient manner.

### Module - domain

Encapsulates core business logic and shared data models (Use Cases) that are reusable across all feature-specific modules of the app.
This layer serves as the backbone for handling business rules, decoupling feature modules from one another while maintaining consistency and scalability.

### Module - app

The Application module itself contains:

- Logic to properly connect all included components together with the help of Dependency Injection (Koin, by default).
- Showcases to demonstrate some features included during [project setup](https://kotli.xyz/project).

Once you download and import the initial project structure into your IDE, the project is ready to run on a device, enabling you to understand the included functionality and start adding the required features.

## Backend

The server architecture is based on either the [Ktor Framework](https://ktor.io) or [Spring Boot](https://spring.io/projects/spring-boot).

Backend-specific logic is implemented in the `backend` module.

To enable sharing some common models between the **backend** and **frontend**, the project also includes a `domain` module as part of the **shared** group.

# Documentation

Once you've configured your project through [Kotli](https://kotli.xyz/project) and downloaded the generated source codes, this project become fully yours and is not bound to the service. Each project includes a README.MD file in its root with the following helpful details:

- A link to the initial template used to prepare the project structure (GitHub page of the template, similar to this one).
- A link to the architecture ([Kotli](https://kotli.xyz/project) project) used to prepare and download these sources.
- A list of all features included in the project during its [setup](https://kotli.xyz/project). Each feature includes additional documentation within the project's `docs` directory, making it easy to check what is included, find official links, and understand how to use and configure each functionality if needed.

All documentation related to features can also be found and accessed online, up-to-date, once you open the link to your Kotli project.

# Showcases

When a project is configured and downloaded via [Kotli](https://kotli.xyz/project), it also provides showcases of all included features. Furthermore, the screen with showcases is configured as the initial screen when running the downloaded template.

|                   Showcases :: Overview                   |                Showcases :: Theme Dialog                |                  Showcases :: Key-Value Storage                   |
|:---------------------------------------------------------:|:-------------------------------------------------------:|:-----------------------------------------------------------------:|
| ![Showcases Overview](images/screenshots/showcases_overview.jpg) | ![Theme Dialog](images/screenshots/showcases_theme_dialog.jpg) | ![Key-Value Storage](images/screenshots/showcases_key_value_objects.jpg) |

# How to use

Once the project is downloaded, it includes the source code as well as a **README.md** file. This file visualizes all the features included as a table. The most useful columns in this table are:

- **Overview** - A summary of the feature, including all official resources used to pre-configure this feature in the template. Use it as a reference to find any additional information related to the feature.
- **Usage** - The main information related to using the feature. Use it as a starting point when you need to start working with the feature and don't know how to begin.

For example, if you configured the project with **Web** and **iOS** platforms but don't know how to run the app on them (💀), find these platforms in the table and open their **Usage** guide.

# Features

The template is highly configurable, allowing you to include only the necessary features in the app.

All these features are optional, will be updated over time, and can be included in the generated structure during [project setup](https://kotli.xyz).

The generated project will include a similar table in its README.MD file, but with only the configured features (direct and transitive).

| Group | Feature | Overview | Configuration | Usage |
|-------|---------|----------|---------------|-------|
| Platform | iOS | [Link](docs/Platform/iOS/overview.md) | - | [Link](docs/Platform/iOS/usage.md) |
| Platform | Android | [Link](docs/Platform/Android/overview.md) | - | [Link](docs/Platform/Android/usage.md) |
| Platform | Desktop | [Link](docs/Platform/Desktop/overview.md) | - | [Link](docs/Platform/Desktop/usage.md) |
| Platform | Web (JS) | [Link](docs/Platform/Web%20%28JS%29/overview.md) | - | [Link](docs/Platform/Web%20%28JS%29/usage.md) |
| Platform | Ktor Server | [Link](docs/Platform/Ktor%20Server/overview.md) | - | [Link](docs/Platform/Ktor%20Server/usage.md) |
| Essentials | Compose Multiplatform | [Link](docs/Essentials/Compose%20Multiplatform/overview.md) | - | - |
| Essentials | Jetpack Navigation | [Link](docs/Essentials/Jetpack%20Navigation/overview.md) | - | [Link](docs/Essentials/Jetpack%20Navigation/usage.md) |
| Essentials | Material 3 | [Link](docs/Essentials/Material%203/overview.md) | - | [Link](docs/Essentials/Material%203/usage.md) |
| Essentials | Koin | [Link](docs/Essentials/Koin/overview.md) | - | - |
| Essentials | Gradle (Kotlin DSL) | [Link](docs/Essentials/Gradle%20%28Kotlin%20DSL%29/overview.md) | - | - |
| Dataflow | Korlibs Crypto Library | [Link](docs/Dataflow/Korlibs%20Crypto%20Library/overview.md) | - | [Link](docs/Dataflow/Korlibs%20Crypto%20Library/usage.md) |
| Dataflow | Basic Cache API | [Link](docs/Dataflow/Basic%20Cache%20API/overview.md) | - | [Link](docs/Dataflow/Basic%20Cache%20API/usage.md) |
| Dataflow | Basic Config API | [Link](docs/Dataflow/Basic%20Config%20API/overview.md) | - | [Link](docs/Dataflow/Basic%20Config%20API/usage.md) |
| Dataflow | SQLDelight | [Link](docs/Dataflow/SQLDelight/overview.md) | - | [Link](docs/Dataflow/SQLDelight/usage.md) |
| Dataflow | SQLite (Room) | [Link](docs/Dataflow/SQLite%20%28Room%29/overview.md) | - | [Link](docs/Dataflow/SQLite%20%28Room%29/usage.md) |
| Dataflow | Ktor HTTP Client | [Link](docs/Dataflow/Ktor%20HTTP%20Client/overview.md) | - | [Link](docs/Dataflow/Ktor%20HTTP%20Client/usage.md) |
| Dataflow | Multiplatform Paging Library | [Link](docs/Dataflow/Multiplatform%20Paging%20Library/overview.md) | - | [Link](docs/Dataflow/Multiplatform%20Paging%20Library/usage.md) |
| Dataflow | Basic Analytics API | [Link](docs/Dataflow/Basic%20Analytics%20API/overview.md) | - | [Link](docs/Dataflow/Basic%20Analytics%20API/usage.md) |
| Dataflow | Gemini AI | [Link](docs/Dataflow/Gemini%20AI/overview.md) | - | [Link](docs/Dataflow/Gemini%20AI/usage.md) |
| Userflow | Coil Image Library | [Link](docs/Userflow/Coil%20Image%20Library/overview.md) | - | [Link](docs/Userflow/Coil%20Image%20Library/usage.md) |
| Userflow | Markdown Text Renderer | [Link](docs/Userflow/Markdown%20Text%20Renderer/overview.md) | - | [Link](docs/Userflow/Markdown%20Text%20Renderer/usage.md) |
| Userflow | Adaptive Navigation | [Link](docs/Userflow/Adaptive%20Navigation/overview.md) | - | [Link](docs/Userflow/Adaptive%20Navigation/usage.md) |
| Userflow | Bottom Navigation | [Link](docs/Userflow/Bottom%20Navigation/overview.md) | - | [Link](docs/Userflow/Bottom%20Navigation/usage.md) |
| Userflow | Dismissible Navigation | [Link](docs/Userflow/Dismissible%20Navigation/overview.md) | - | [Link](docs/Userflow/Dismissible%20Navigation/usage.md) |
| Userflow | Modal Navigation | [Link](docs/Userflow/Modal%20Navigation/overview.md) | - | [Link](docs/Userflow/Modal%20Navigation/usage.md) |
| Userflow | Permanent Navigation | [Link](docs/Userflow/Permanent%20Navigation/overview.md) | - | [Link](docs/Userflow/Permanent%20Navigation/usage.md) |
| Userflow | Rail Navigation | [Link](docs/Userflow/Rail%20Navigation/overview.md) | - | [Link](docs/Userflow/Rail%20Navigation/usage.md) |
| Userflow | Save Theme API | [Link](docs/Userflow/Save%20Theme%20API/overview.md) | - | [Link](docs/Userflow/Save%20Theme%20API/usage.md) |
| Userflow | Change Theme Screen | [Link](docs/Userflow/Change%20Theme%20Screen/overview.md) | - | [Link](docs/Userflow/Change%20Theme%20Screen/usage.md) |
| Userflow | Toggle Theme Button | [Link](docs/Userflow/Toggle%20Theme%20Button/overview.md) | - | [Link](docs/Userflow/Toggle%20Theme%20Button/usage.md) |
| Userflow | Data Loading Indicator | [Link](docs/Userflow/Data%20Loading%20Indicator/overview.md) | - | [Link](docs/Userflow/Data%20Loading%20Indicator/usage.md) |
| Userflow | Passcode Flow | [Link](docs/Userflow/Passcode%20Flow/overview.md) | - | [Link](docs/Userflow/Passcode%20Flow/usage.md) |
| Userflow | Placeholder UI | [Link](docs/Userflow/Placeholder%20UI/overview.md) | - | [Link](docs/Userflow/Placeholder%20UI/usage.md) |
| Userflow | FileKit | [Link](docs/Userflow/FileKit/overview.md) | - | [Link](docs/Userflow/FileKit/usage.md) |
| Testing | kotlin-logging | [Link](docs/Testing/kotlin-logging/overview.md) | - | [Link](docs/Testing/kotlin-logging/usage.md) |
| Testing | Kermit | [Link](docs/Testing/Kermit/overview.md) | - | [Link](docs/Testing/Kermit/usage.md) |
| Testing | Napier | [Link](docs/Testing/Napier/overview.md) | - | [Link](docs/Testing/Napier/usage.md) |