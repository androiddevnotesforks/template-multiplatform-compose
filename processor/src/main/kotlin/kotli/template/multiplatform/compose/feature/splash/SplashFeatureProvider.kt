package kotli.template.multiplatform.compose.feature.splash

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProvider
import kotli.template.multiplatform.compose.feature.splash.basic.SplashClientBasicProcessor

object SplashFeatureProvider : UserFeatureProvider() {

    override fun getId(): String = "feature.splash"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        SplashClientApiProcessor,
        SplashClientBasicProcessor
    )
}