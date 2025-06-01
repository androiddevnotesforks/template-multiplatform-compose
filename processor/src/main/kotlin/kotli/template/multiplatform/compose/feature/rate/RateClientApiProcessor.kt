package kotli.template.multiplatform.compose.feature.rate

import kotli.template.multiplatform.compose.feature.UserFeatureProcessor

object RateClientApiProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:rate:client:api"

    override val featureName: String = "RateFeature"

    override fun isInternal(): Boolean = true
}