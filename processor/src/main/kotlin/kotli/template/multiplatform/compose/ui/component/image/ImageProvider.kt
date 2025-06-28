package kotli.template.multiplatform.compose.ui.component.image

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.ui.component.ComponentProvider
import kotli.template.multiplatform.compose.ui.component.image.coil.CoilProcessor

object ImageProvider : ComponentProvider() {

    override fun getId(): String = "ui.component.image"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        CoilProcessor
    )
}