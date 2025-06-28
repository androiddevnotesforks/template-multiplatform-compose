package kotli.template.multiplatform.compose.feature.navigation

import kotli.engine.TemplateState
import kotli.engine.template.rule.CleanupMarkedBlock
import kotli.engine.template.rule.RemoveMarkedBlock
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor

object NavigationClientApiProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:navigation:client:api"

    override val featureName: String = "NavigationFeature"

    override fun isInternal(): Boolean = true

    override fun doApply(state: TemplateState) {
        super.doApply(state)
        state.onApplyRules(
            Rules.ClientAppViewModelKt,
            CleanupMarkedBlock("{feature.navigation.client.api}")
        )
    }

    override fun doRemove(state: TemplateState) {
        super.doRemove(state)
        state.onApplyRules(
            Rules.ClientAppViewModelKt,
            RemoveMarkedBlock("{feature.navigation.client.api}"),
            RemoveMarkedLine("navigation"),
            RemoveMarkedLine("Icons")
        )
    }
}