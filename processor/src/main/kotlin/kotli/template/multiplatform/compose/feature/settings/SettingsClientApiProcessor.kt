package kotli.template.multiplatform.compose.feature.settings

import kotli.template.multiplatform.compose.feature.UserFeatureProcessor

object SettingsClientApiProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:settings:client:api"

    override val featureName: String = "SettingsFeature"

    override fun isInternal(): Boolean = true
}