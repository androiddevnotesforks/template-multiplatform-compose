package kotli.template.multiplatform.compose.feature.analytics

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProvider

object AnalyticsFeatureProvider : UserFeatureProvider() {

    override fun getId(): String = "feature.analytics"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        AnalyticsClientApiProcessor,
        AnalyticsClientStubProcessor
    )
}