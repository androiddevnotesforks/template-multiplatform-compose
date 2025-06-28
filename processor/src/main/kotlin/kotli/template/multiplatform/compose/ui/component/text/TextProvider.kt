package kotli.template.multiplatform.compose.ui.component.text

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.ui.component.ComponentProvider
import kotli.template.multiplatform.compose.ui.component.text.markdown.MarkdownProcessor

object TextProvider : ComponentProvider() {

    override fun getId(): String = "ui.component.text"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        MarkdownProcessor
    )
}