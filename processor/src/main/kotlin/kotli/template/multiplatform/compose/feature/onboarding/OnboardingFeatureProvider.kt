package kotli.template.multiplatform.compose.feature.onboarding

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProvider

object OnboardingFeatureProvider : UserFeatureProvider() {

    override fun getId(): String = "feature.onboarding"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        OnboardingClientApiProcessor,
        OnboardingClientBasicProcessor
    )
}