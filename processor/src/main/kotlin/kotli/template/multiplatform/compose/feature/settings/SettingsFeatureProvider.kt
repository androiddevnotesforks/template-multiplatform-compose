package kotli.template.multiplatform.compose.feature.settings

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProvider
import kotli.template.multiplatform.compose.feature.settings.stub.SettingsClientStubProcessor

object SettingsFeatureProvider : UserFeatureProvider() {

    override fun getId(): String = "feature.settings"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        SettingsClientApiProcessor,
        SettingsClientStubProcessor
    )
}