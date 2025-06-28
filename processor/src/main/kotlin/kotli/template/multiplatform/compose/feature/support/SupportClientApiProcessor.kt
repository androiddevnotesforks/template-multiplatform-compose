package kotli.template.multiplatform.compose.feature.support

import kotli.template.multiplatform.compose.feature.UserFeatureProcessor

object SupportClientApiProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:support:client:api"

    override val featureName: String = "SupportFeature"

    override fun isInternal(): Boolean = true
}