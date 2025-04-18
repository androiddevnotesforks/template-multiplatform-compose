package kotli.template.multiplatform.compose.userflow.theme.toggle

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.showcases.userflow.theme.toggle.ToggleThemeShowcasesProcessor
import kotli.template.multiplatform.compose.userflow.theme.save.SaveThemeProcessor
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.hours

object ToggleThemeProcessor : BaseFeatureProcessor() {

    const val ID = "userflow.theme.toggle"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.AllClients
    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        SaveThemeProcessor::class,
        ToggleThemeShowcasesProcessor::class
    )

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.AppThemeConfigKt,
            RemoveMarkedLine("ToggleTheme")
        )
        state.onApplyRules(
            "${Rules.AppTheme}/toggle",
            RemoveFile()
        )
    }

}