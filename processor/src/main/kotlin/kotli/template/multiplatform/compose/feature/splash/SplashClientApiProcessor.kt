package kotli.template.multiplatform.compose.feature.splash

import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor

object SplashClientApiProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:splash:client:api"

    override val featureName: String = "SplashFeature"

    override fun isInternal(): Boolean = true

    override fun doRemove(state: TemplateState) {
        super.doRemove(state)
        state.onApplyRules(
            Rules.ClientAppViewModelKt,
            RemoveMarkedLine("splash")
        )
    }
}