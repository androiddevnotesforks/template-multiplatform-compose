package kotli.template.multiplatform.compose.platform.shared

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.CleanupMarkedBlock
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

object SharedDomainProcessor : BaseFeatureProcessor() {

    const val ID = "platform.shared.domain"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.DomainBuildGradle,
            CleanupMarkedBlock("{platform.shared.domain}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.DomainDir,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.BuildGradle,
            RemoveMarkedLine("shared.domain")
        )
        state.onApplyRules(
            Rules.RootSettingsGradle,
            RemoveMarkedLine("shared:domain")
        )
    }

}