plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.library)
}

kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    js { browser() }
    jvm()

    sourceSets {
        all {
            languageSettings {
                optIn("kotlinx.serialization.InternalSerializationApi")
            }
        }
        commonMain.dependencies {
            implementation(compose.components.resources)
            implementation(projects.shared.presentation)
        }
    }
}

android {
    namespace = "feature.common.api"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
}