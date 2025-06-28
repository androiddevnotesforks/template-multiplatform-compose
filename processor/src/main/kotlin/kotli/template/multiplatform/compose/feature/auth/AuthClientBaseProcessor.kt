package kotli.template.multiplatform.compose.feature.auth

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor
import kotlin.reflect.KClass

object AuthClientBaseProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:auth:client:base"

    override fun isInternal(): Boolean = true

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        AuthClientApiProcessor::class
    )
}