package kotli.template.multiplatform.compose.feature.passcode

import kotli.template.multiplatform.compose.feature.UserFeatureProcessor

object PasscodeClientApiProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:passcode:client:api"

    override val featureName: String = "PasscodeFeature"

    override fun isInternal(): Boolean = true
}