package kotli.template.multiplatform.compose.feature.auth.stub

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor
import kotli.template.multiplatform.compose.feature.auth.AuthClientBaseProcessor
import kotlin.reflect.KClass

object AuthClientStubProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:auth:client:stub"

    override val featureName: String = "StubAuthProvider"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        AuthClientBaseProcessor::class
    )
}