package kotli.template.multiplatform.compose.data.config

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.data.BaseDataProvider
import kotli.template.multiplatform.compose.data.config.basic.BasicConfigProcessor

object ConfigProvider : BaseDataProvider() {

    override fun getId(): String = "data.config"
    override fun isMultiple(): Boolean = true
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        BasicConfigProcessor
    )

}