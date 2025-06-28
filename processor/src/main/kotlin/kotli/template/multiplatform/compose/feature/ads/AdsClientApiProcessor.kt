package kotli.template.multiplatform.compose.feature.ads

import kotli.template.multiplatform.compose.feature.UserFeatureProcessor

object AdsClientApiProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:ads:client:api"

    override val featureName: String = "AdsFeature"

    override fun isInternal(): Boolean = true
}