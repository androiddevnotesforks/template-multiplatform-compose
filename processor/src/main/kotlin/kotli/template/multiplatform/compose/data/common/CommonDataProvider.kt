package kotli.template.multiplatform.compose.data.common

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes

object CommonDataProvider : BaseFeatureProvider() {

    override fun getId(): String = "data.common"
    override fun getType(): FeatureType = FeatureTypes.DataLayer
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        CommonDataProcessor
    )

}