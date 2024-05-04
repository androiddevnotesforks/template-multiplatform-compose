package kotli.template.multiplatform.compose.testing.logging.kermit

import kotli.engine.BaseFeatureProcessor
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.CleanupMarkedLine
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotlin.time.Duration.Companion.minutes

object KermitProcessor : BaseFeatureProcessor() {

    const val ID = "testing.logging.kermit"

    override fun getId(): String = ID
    override fun getWebUrl(state: TemplateState): String = "https://kermit.touchlab.co"
    override fun getIntegrationUrl(state: TemplateState): String = "https://kermit.touchlab.co/docs/#getting-started"
    override fun getIntegrationEstimate(state: TemplateState): Long = 15.minutes.inWholeMilliseconds

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.BuildGradleComposeApp,
            RemoveMarkedLine("kermit")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("kermit")
            )
        )
    }

}