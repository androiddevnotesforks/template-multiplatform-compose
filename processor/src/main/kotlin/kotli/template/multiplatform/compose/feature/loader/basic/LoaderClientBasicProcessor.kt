package kotli.template.multiplatform.compose.feature.loader.basic

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor
import kotli.template.multiplatform.compose.feature.loader.LoaderClientApiProcessor
import kotlin.reflect.KClass

object LoaderClientBasicProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:loader:client:basic"

    override val featureName: String = "BasicLoaderProvider"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        LoaderClientApiProcessor::class
    )
}