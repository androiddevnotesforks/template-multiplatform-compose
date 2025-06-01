package kotli.template.multiplatform.compose.ui.component.file.filekit

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotlin.time.Duration.Companion.minutes

object FileKitProcessor : BaseFeatureProcessor() {

    const val ID = "ui.component.file.filekit"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 30.minutes.inWholeMilliseconds
    override fun getWebUrl(state: TemplateState): String = "https://github.com/vinceglb/FileKit"
    override fun getIntegrationUrl(state: TemplateState): String =
        "https://github.com/vinceglb/FileKit?tab=readme-ov-file#-quick-start"

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.PresentationBuildGradle,
            RemoveMarkedLine("filekit")
        )

        state.onApplyRules(
            Rules.PresentationComponentFilePicker,
            RemoveFile()
        )

        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("filekit")
            )
        )
    }

}