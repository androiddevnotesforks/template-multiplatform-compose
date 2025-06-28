package kotli.template.multiplatform.compose.feature.onboarding

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor
import kotlin.reflect.KClass

object OnboardingClientBasicProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:onboarding:client:basic"

    override val featureName: String = "BasicOnboardingProvider"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        OnboardingClientApiProcessor::class
    )

    override fun isInternal(): Boolean = true
}