package kotli.template.multiplatform.compose.feature.common

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor
import kotlin.reflect.KClass

object CommonClientKoinProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:common:client:koin"

    override fun isInternal(): Boolean = true

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        CommonClientApiProcessor::class
    )
}