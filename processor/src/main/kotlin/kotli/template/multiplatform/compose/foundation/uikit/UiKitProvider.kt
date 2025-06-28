package kotli.template.multiplatform.compose.foundation.uikit

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.foundation.FoundationProvider
import kotli.template.multiplatform.compose.foundation.uikit.compose.ComposeProcessor

object UiKitProvider : FoundationProvider() {

    override fun getId(): String = "foundation.uikit"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        ComposeProcessor
    )

}