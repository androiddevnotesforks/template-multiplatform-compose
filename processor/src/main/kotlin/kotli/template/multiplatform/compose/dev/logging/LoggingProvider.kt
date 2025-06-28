package kotli.template.multiplatform.compose.dev.logging

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes
import kotli.template.multiplatform.compose.dev.logging.kermit.KermitProcessor
import kotli.template.multiplatform.compose.dev.logging.napier.NapierProcessor
import kotli.template.multiplatform.compose.dev.logging.oshai.OshaiProcessor

object LoggingProvider : BaseFeatureProvider() {

    override fun getId(): String = "dev.logging"
    override fun isMultiple(): Boolean = false
    override fun getType(): FeatureType = FeatureTypes.DevTools
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        OshaiProcessor,
        KermitProcessor,
        NapierProcessor
    )

}