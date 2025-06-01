package kotli.template.multiplatform.compose.feature.update

import kotli.template.multiplatform.compose.feature.UserFeatureProcessor

object UpdateClientApiProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:update:client:api"

    override val featureName: String = "UpdateFeature"

    override fun isInternal(): Boolean = true
}