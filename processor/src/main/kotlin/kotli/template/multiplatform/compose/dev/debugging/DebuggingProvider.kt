package kotli.template.multiplatform.compose.dev.debugging

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes
import kotli.template.multiplatform.compose.dev.debugging.hotreload.HotReloadProcessor

object DebuggingProvider : BaseFeatureProvider() {

    override fun getId(): String = "dev.debugging"
    override fun isMultiple(): Boolean = true
    override fun getType(): FeatureType = FeatureTypes.DevTools
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        HotReloadProcessor
    )
}