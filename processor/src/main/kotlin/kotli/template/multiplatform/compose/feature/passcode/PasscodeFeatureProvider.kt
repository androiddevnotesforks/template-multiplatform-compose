package kotli.template.multiplatform.compose.feature.passcode

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProvider
import kotli.template.multiplatform.compose.feature.passcode.basic.PasscodeClientBasicProcessor

object PasscodeFeatureProvider : UserFeatureProvider() {

    override fun getId(): String = "feature.passcode"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        PasscodeClientApiProcessor,
        PasscodeClientBasicProcessor
    )
}