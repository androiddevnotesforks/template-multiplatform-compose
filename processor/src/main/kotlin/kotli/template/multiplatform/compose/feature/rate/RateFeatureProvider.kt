package kotli.template.multiplatform.compose.feature.rate

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProvider
import kotli.template.multiplatform.compose.feature.rate.stub.RateClientStubProcessor

object RateFeatureProvider : UserFeatureProvider() {

    override fun getId(): String = "feature.rate"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        RateClientApiProcessor,
        RateClientStubProcessor
    )
}