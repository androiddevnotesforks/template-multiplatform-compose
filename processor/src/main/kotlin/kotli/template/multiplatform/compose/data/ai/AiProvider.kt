package kotli.template.multiplatform.compose.data.ai

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.data.BaseDataProvider
import kotli.template.multiplatform.compose.data.ai.gemini.GeminiProcessor

object AiProvider : BaseDataProvider() {

    override fun getId(): String = "data.ai"
    override fun isMultiple(): Boolean = true
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        GeminiProcessor
    )

}