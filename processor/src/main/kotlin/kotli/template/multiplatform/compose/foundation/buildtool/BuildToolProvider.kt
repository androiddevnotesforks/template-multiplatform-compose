package kotli.template.multiplatform.compose.foundation.buildtool

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.foundation.FoundationProvider
import kotli.template.multiplatform.compose.foundation.buildtool.gradle.GradleProcessor

object BuildToolProvider : FoundationProvider() {

    override fun getId(): String = "foundation.build"
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        GradleProcessor
    )

}