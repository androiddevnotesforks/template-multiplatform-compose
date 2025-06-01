package kotli.template.multiplatform.compose.feature.loader

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProvider
import kotli.template.multiplatform.compose.feature.loader.basic.LoaderClientBasicProcessor

object LoaderFeatureProvider : UserFeatureProvider() {

    override fun getId(): String = "feature.loader"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        LoaderClientApiProcessor,
        LoaderClientBasicProcessor
    )
}