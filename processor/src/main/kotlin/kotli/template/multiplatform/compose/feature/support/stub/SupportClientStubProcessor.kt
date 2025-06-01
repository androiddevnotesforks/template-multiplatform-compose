package kotli.template.multiplatform.compose.feature.support.stub

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor
import kotli.template.multiplatform.compose.feature.support.SupportClientApiProcessor
import kotlin.reflect.KClass

object SupportClientStubProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:support:client:stub"

    override val featureName: String = "StubSupportProvider"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        SupportClientApiProcessor::class
    )

    override fun isInternal(): Boolean = true
}