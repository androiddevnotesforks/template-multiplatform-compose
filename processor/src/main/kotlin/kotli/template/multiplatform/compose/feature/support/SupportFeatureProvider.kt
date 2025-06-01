package kotli.template.multiplatform.compose.feature.support

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProvider
import kotli.template.multiplatform.compose.feature.support.stub.SupportClientStubProcessor

object SupportFeatureProvider : UserFeatureProvider() {

    override fun getId(): String = "feature.support"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        SupportClientApiProcessor,
        SupportClientStubProcessor
    )
}