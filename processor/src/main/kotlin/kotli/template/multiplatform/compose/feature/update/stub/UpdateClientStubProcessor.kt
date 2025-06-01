package kotli.template.multiplatform.compose.feature.update.stub

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor
import kotli.template.multiplatform.compose.feature.update.UpdateClientApiProcessor
import kotlin.reflect.KClass

object UpdateClientStubProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:update:client:stub"

    override val featureName: String = "StubUpdateProvider"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        UpdateClientApiProcessor::class
    )

    override fun isInternal(): Boolean = true
}