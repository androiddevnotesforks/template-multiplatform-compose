package kotli.template.multiplatform.compose.data.settings.multiplatform

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.CleanupMarkedLine
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.data.settings.common.CommonSettingsProcessor
import kotli.template.multiplatform.compose.platform.client.js.JsPlatformProcessor
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.hours

object MultiplatformSettingsProcessor : BaseFeatureProcessor() {

    const val ID = "data.settings.multiplatform"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getWebUrl(state: TemplateState): String =
        "https://github.com/russhwolf/multiplatform-settings"

    override fun getIntegrationUrl(state: TemplateState): String =
        "https://github.com/russhwolf/multiplatform-settings?tab=readme-ov-file#no-arg-module"

    override fun getIntegrationEstimate(state: TemplateState): Long = 2.hours.inWholeMilliseconds

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        CommonSettingsProcessor::class
    )

    override fun canApply(state: TemplateState): Boolean {
        return state.getFeature(JsPlatformProcessor.ID) != null
    }

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.DataBuildGradle,
            CleanupMarkedLine("{data.settings.multiplatform}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.MultiplatformSettingsSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.DataBuildGradle,
            RemoveMarkedLine("multiplatform.settings")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("multiplatform-settings")
            )
        )
        state.onApplyRules(
            Rules.ClientCommonConfigKt,
            RemoveMarkedLine("SettingsSource")
        )
    }

}