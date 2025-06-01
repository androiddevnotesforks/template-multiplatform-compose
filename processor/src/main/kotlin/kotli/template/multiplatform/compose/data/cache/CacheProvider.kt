package kotli.template.multiplatform.compose.data.cache

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.data.BaseDataProvider
import kotli.template.multiplatform.compose.data.cache.basic.BasicCacheProcessor

object CacheProvider : BaseDataProvider() {

    override fun getId(): String = "data.cache"
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        BasicCacheProcessor
    )

}