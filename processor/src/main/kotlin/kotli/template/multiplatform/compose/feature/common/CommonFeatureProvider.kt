package kotli.template.multiplatform.compose.feature.common

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes

object CommonFeatureProvider : BaseFeatureProvider() {

    override fun getId(): String = "feature.common"

    override fun getType(): FeatureType = FeatureTypes.Unspecified

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        CommonClientApiProcessor,
        CommonClientKoinProcessor
    )
}