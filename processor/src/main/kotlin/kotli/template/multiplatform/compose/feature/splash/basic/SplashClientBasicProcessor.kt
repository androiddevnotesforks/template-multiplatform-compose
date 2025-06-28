package kotli.template.multiplatform.compose.feature.splash.basic

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor
import kotli.template.multiplatform.compose.feature.splash.SplashClientApiProcessor
import kotlin.reflect.KClass

object SplashClientBasicProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:splash:client:basic"

    override val featureName: String = "BasicSplashProvider"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        SplashClientApiProcessor::class
    )
}