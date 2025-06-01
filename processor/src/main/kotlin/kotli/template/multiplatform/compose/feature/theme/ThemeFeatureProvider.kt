package kotli.template.multiplatform.compose.feature.theme

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProvider
import kotli.template.multiplatform.compose.feature.theme.basic.ThemeClientBasicProcessor

object ThemeFeatureProvider : UserFeatureProvider() {

    override fun getId(): String = "feature.theme"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        ThemeClientApiProcessor,
        ThemeClientBasicProcessor
    )
}