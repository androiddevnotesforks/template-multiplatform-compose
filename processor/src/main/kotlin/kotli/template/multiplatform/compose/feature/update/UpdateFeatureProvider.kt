package kotli.template.multiplatform.compose.feature.update

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProvider
import kotli.template.multiplatform.compose.feature.update.stub.UpdateClientStubProcessor

object UpdateFeatureProvider : UserFeatureProvider() {

    override fun getId(): String = "feature.update"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        UpdateClientApiProcessor,
        UpdateClientStubProcessor
    )
}