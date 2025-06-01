package kotli.template.multiplatform.compose.ui.component.file

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.ui.component.ComponentProvider
import kotli.template.multiplatform.compose.ui.component.file.filekit.FileKitProcessor

object FileProvider : ComponentProvider() {

    override fun getId(): String = "ui.component.file"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        FileKitProcessor
    )
}