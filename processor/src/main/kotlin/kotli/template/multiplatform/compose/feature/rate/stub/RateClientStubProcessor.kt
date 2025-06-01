package kotli.template.multiplatform.compose.feature.rate.stub

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor
import kotli.template.multiplatform.compose.feature.rate.RateClientApiProcessor
import kotlin.reflect.KClass

object RateClientStubProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:rate:client:stub"

    override val featureName: String = "StubRateProvider"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        RateClientApiProcessor::class
    )

    override fun isInternal(): Boolean = true
}