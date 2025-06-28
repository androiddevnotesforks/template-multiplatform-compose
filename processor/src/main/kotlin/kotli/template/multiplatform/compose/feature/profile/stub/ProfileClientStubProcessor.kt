package kotli.template.multiplatform.compose.feature.profile.stub

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor
import kotli.template.multiplatform.compose.feature.profile.ProfileClientApiProcessor
import kotlin.reflect.KClass

object ProfileClientStubProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:profile:client:stub"

    override val featureName: String = "StubProfileProvider"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        ProfileClientApiProcessor::class
    )

    override fun isInternal(): Boolean = true
}