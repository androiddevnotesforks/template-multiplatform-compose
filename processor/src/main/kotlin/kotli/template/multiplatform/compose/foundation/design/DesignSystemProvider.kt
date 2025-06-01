package kotli.template.multiplatform.compose.foundation.design

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.foundation.FoundationProvider
import kotli.template.multiplatform.compose.foundation.design.material3.Material3Processor

object DesignSystemProvider : FoundationProvider() {

    override fun getId(): String = "foundation.design"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        Material3Processor
    )
}