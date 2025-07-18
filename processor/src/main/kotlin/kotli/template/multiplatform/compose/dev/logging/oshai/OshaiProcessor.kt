package kotli.template.multiplatform.compose.dev.logging.oshai

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotlin.time.Duration.Companion.minutes

object OshaiProcessor : BaseFeatureProcessor() {

    const val ID = "dev.logging.oshai"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getWebUrl(state: TemplateState): String = "https://github.com/oshai/kotlin-logging"
    override fun getIntegrationUrl(state: TemplateState): String =
        "https://github.com/oshai/kotlin-logging/wiki/Multiplatform-support"

    override fun getIntegrationEstimate(state: TemplateState): Long = 15.minutes.inWholeMilliseconds

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ClientBuildGradle,
            RemoveMarkedLine("kotlin.logging")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("kotlin-logging"),
                RemoveMarkedLine("slf4j-simple"),
            )
        )
    }

}