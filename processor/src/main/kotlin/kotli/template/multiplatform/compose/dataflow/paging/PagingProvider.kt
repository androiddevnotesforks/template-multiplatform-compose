package kotli.template.multiplatform.compose.dataflow.paging

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.dataflow.BaseDataFlowProvider
import kotli.template.multiplatform.compose.dataflow.common.CommonDataFlowProcessor
import kotli.template.multiplatform.compose.dataflow.paging.jetpack.JetpackPagingProcessor
import kotli.template.multiplatform.compose.dataflow.paging.multiplatform.MultiplatformPagingProcessor
import kotli.template.multiplatform.compose.showcases.dataflow.paging.PagingShowcasesProcessor
import kotlin.reflect.KClass

object PagingProvider : BaseDataFlowProvider() {

    override fun getId(): String = "dataflow.paging"

    override fun isMultiple(): Boolean = false

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        PagingShowcasesProcessor::class,
        CommonDataFlowProcessor::class,
        CommonPagingProcessor::class
    )

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        CommonPagingProcessor,
        MultiplatformPagingProcessor,
        JetpackPagingProcessor
    )

}