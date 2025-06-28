package kotli.template.multiplatform.compose.feature.onboarding

import kotli.template.multiplatform.compose.feature.UserFeatureProcessor

object OnboardingClientApiProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:onboarding:client:api"

    override val featureName: String = "OnboardingFeature"

    override fun isInternal(): Boolean = true
}