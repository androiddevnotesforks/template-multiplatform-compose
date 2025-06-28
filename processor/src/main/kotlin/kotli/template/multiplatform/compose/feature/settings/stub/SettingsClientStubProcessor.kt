package kotli.template.multiplatform.compose.feature.settings.stub

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor
import kotli.template.multiplatform.compose.feature.settings.SettingsClientApiProcessor
import kotlin.reflect.KClass

object SettingsClientStubProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:settings:client:stub"

    override val featureName: String = "StubSettingsProvider"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        SettingsClientApiProcessor::class
    )

    override fun isInternal(): Boolean = true
}