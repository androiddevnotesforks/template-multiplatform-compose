package kotli.template.multiplatform.compose.feature.navigation.basic

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor
import kotli.template.multiplatform.compose.feature.navigation.NavigationClientApiProcessor
import kotlin.reflect.KClass

object NavigationClientBasicProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:navigation:client:basic"

    override val featureName: String = "BasicNavigationProvider"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        NavigationClientApiProcessor::class
    )
}