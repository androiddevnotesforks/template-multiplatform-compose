package kotli.template.multiplatform.compose.data.encryption

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.data.BaseDataProvider
import kotli.template.multiplatform.compose.data.encryption.korlibs.KorlibsEncryptionProcessor

object EncryptionProvider : BaseDataProvider() {

    override fun getId(): String = "data.encryption"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        KorlibsEncryptionProcessor,
    )
}