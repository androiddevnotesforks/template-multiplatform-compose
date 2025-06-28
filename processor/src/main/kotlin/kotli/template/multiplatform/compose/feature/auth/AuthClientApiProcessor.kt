package kotli.template.multiplatform.compose.feature.auth

import kotli.template.multiplatform.compose.feature.UserFeatureProcessor

object AuthClientApiProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:auth:client:api"

    override val featureName: String = "AuthFeature"

    override fun isInternal(): Boolean = true
}