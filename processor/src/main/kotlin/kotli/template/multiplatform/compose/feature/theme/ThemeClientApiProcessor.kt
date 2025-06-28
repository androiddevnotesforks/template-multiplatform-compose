package kotli.template.multiplatform.compose.feature.theme

import kotli.template.multiplatform.compose.feature.UserFeatureProcessor

object ThemeClientApiProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:theme:client:api"

    override val featureName: String = "ThemeFeature"

    override fun isInternal(): Boolean = true
}