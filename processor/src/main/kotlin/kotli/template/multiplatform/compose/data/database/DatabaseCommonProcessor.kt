package kotli.template.multiplatform.compose.data.database

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules

object DatabaseCommonProcessor : BaseFeatureProcessor() {

    const val ID = "data.database.common"
    override fun isInternal(): Boolean = true

    override fun getId(): String = ID

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ClientCommonDatabase,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.ClientPlatformConfigKt,
            RemoveMarkedLine("DatabaseSource")
        )
    }

}