package kotli.template.multiplatform.compose.feature.navigation

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProvider
import kotli.template.multiplatform.compose.feature.navigation.basic.NavigationClientBasicProcessor

object NavigationFeatureProvider : UserFeatureProvider() {

    override fun getId(): String = "feature.navigation"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        NavigationClientApiProcessor,
        NavigationClientBasicProcessor
    )
}