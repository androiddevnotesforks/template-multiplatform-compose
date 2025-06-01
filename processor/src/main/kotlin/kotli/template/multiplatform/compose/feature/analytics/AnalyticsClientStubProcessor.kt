package kotli.template.multiplatform.compose.feature.analytics

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor
import kotlin.reflect.KClass

object AnalyticsClientStubProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:analytics:client:stub"

    override val featureName: String = "StubAnalyticsProvider"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        AnalyticsClientApiProcessor::class
    )

    override fun isInternal(): Boolean = true
}