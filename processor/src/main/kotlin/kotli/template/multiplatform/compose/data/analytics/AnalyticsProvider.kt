package kotli.template.multiplatform.compose.data.analytics

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.data.BaseDataProvider
import kotli.template.multiplatform.compose.data.analytics.basic.BasicAnalyticsProcessor

object AnalyticsProvider : BaseDataProvider() {

    override fun getId(): String = "data.analytics"
    override fun isMultiple(): Boolean = true
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        BasicAnalyticsProcessor
    )

}