package kotli.template.multiplatform.compose.feature.ads

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor
import kotlin.reflect.KClass

object AdsClientStubProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:ads:client:stub"

    override val featureName: String = "StubAdsProvider"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        AdsClientApiProcessor::class
    )

    override fun isInternal(): Boolean = true
}