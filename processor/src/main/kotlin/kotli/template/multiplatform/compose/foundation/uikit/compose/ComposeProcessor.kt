package kotli.template.multiplatform.compose.foundation.uikit.compose

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.model.FeatureTags
import kotlin.time.Duration.Companion.hours

object ComposeProcessor : BaseFeatureProcessor() {

    const val ID = "foundation.uikit.compose"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true
    override fun getTags(): List<FeatureTag> = listOf(FeatureTags.Client)
    override fun getWebUrl(state: TemplateState): String = "https://www.jetbrains.com/lp/compose-multiplatform/"
    override fun getIntegrationUrl(state: TemplateState): String =
        "https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-getting-started.html"

    override fun getIntegrationEstimate(state: TemplateState): Long = 8.hours.inWholeMilliseconds

}