package kotli.template.multiplatform.compose.feature.analytics

import kotli.template.multiplatform.compose.feature.UserFeatureProcessor

object AnalyticsClientApiProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:analytics:client:api"

    override val featureName: String = "AnalyticsFeature"

    override fun isInternal(): Boolean = true
}