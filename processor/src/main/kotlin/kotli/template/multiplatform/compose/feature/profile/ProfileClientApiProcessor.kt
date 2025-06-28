package kotli.template.multiplatform.compose.feature.profile

import kotli.template.multiplatform.compose.feature.UserFeatureProcessor

object ProfileClientApiProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:profile:client:api"

    override val featureName: String = "ProfileFeature"

    override fun isInternal(): Boolean = true
}