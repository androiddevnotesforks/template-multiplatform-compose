package kotli.template.multiplatform.compose.foundation.navigation

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.foundation.FoundationProvider
import kotli.template.multiplatform.compose.foundation.navigation.jetpack.JetpackProcessor

object NavigationProvider : FoundationProvider() {

    override fun getId(): String = "foundation.navigation"
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        JetpackProcessor
    )
}