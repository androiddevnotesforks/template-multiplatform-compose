package kotli.template.multiplatform.compose.foundation.di.koin

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.model.FeatureTags
import kotlin.time.Duration.Companion.hours

object KoinProcessor : BaseFeatureProcessor() {

    const val ID = "foundation.di.koin"

    override fun getId(): String = ID
    override fun isInternal(): Boolean = true
    override fun getTags(): List<FeatureTag> = listOf(FeatureTags.Client, FeatureTags.Server)
    override fun getWebUrl(state: TemplateState): String = "https://insert-koin.io"
    override fun getIntegrationUrl(state: TemplateState): String =
        "https://insert-koin.io/docs/reference/koin-mp/kmp"

    override fun getIntegrationEstimate(state: TemplateState): Long = 1.hours.inWholeMilliseconds

}