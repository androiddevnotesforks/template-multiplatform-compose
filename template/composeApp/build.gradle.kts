import org.jetbrains.compose.desktop.application.dsl.TargetFormat // {platform.jvm}

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.androidApplication) // {platform.android}
    alias(libs.plugins.skie) // {platform.ios}
}

kotlin {
    // {platform.android.target}
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
    // {platform.android.target}
    // {platform.ios.target}
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    // {platform.ios.target}
    // {platform.js.target}
    js(IR) {
        browser {
            commonWebpackConfig {
                outputFileName = "app.js"
            }
        }
        binaries.executable()
    }
    // {platform.js.target}
    // {platform.jvm.target}
    jvm()
    // {platform.jvm.target}
    applyDefaultHierarchyTemplate()
    sourceSets {
        all {
            languageSettings {
                optIn("androidx.compose.material3.ExperimentalMaterial3Api")
                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
            }
        }
        commonMain.dependencies {
            implementation(compose.components.resources)
            implementation(libs.koin.core)
            implementation(projects.shared.core)
            implementation(projects.shared.data)
            implementation(projects.shared.design)
        }
        // {platform.android.dependencies}
        androidMain.dependencies {
            implementation(libs.androidx.splashscreen)
        }
        // {platform.android.dependencies}
        // {platform.jvm.dependencies}
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
        // {platform.jvm.dependencies}
    }
}

// {platform.android.config}
android {
    namespace = "app"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "kotli.app"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}
// {platform.android.config}
// {platform.js.config}
compose.experimental {
    web.application {}
}
// {platform.js.config}
// {platform.jvm.config}
compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "app"
            packageVersion = "1.0.0"
            modules(
                "java.net.http"
            )
        }
        buildTypes.release.proguard {
            obfuscate.set(true)
            configurationFiles.from(project.file("assemble/proguard-rules.pro"))
        }
    }
}
// {platform.jvm.config}
