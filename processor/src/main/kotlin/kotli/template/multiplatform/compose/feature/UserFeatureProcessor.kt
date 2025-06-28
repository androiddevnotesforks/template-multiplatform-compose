package kotli.template.multiplatform.compose.feature

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.model.FeatureTags
import kotli.engine.template.rule.CleanupMarkedBlock
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedBlock
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotlin.time.Duration.Companion.hours

abstract class UserFeatureProcessor : BaseFeatureProcessor() {

    final override fun getId(): String = moduleName.replace(":", ".")

    override fun getTags(): List<FeatureTag> = Tags.AllClients

    override fun getIntegrationEstimate(state: TemplateState): Long =
        if (isInternal()) 0L else 8.hours.inWholeMilliseconds

    protected abstract val moduleName: String
    protected open val featureName: String? = null

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.ClientAppConfigKt,
            CleanupMarkedBlock("{${moduleName.replace(":", ".")}}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.RootSettingsGradle,
            RemoveMarkedLine(moduleName)
        )
        state.onApplyRules(
            Rules.ClientBuildGradle,
            RemoveMarkedLine(moduleName.replace(":", "."))
        )
        state.onApplyRules(
            moduleName.replace(":", "/"),
            RemoveFile()
        )
        state.onApplyRules(
            Rules.ClientAppConfigKt,
            RemoveMarkedBlock("{${moduleName.replace(":", ".")}}")
        )
        featureName?.let {
            state.onApplyRules(
                Rules.ClientAppConfigKt,
                RemoveMarkedLine(it)
            )
        }
    }
}