package kotli.template.multiplatform.compose.data.expression

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.data.BaseDataProvider
import kotli.template.multiplatform.compose.data.expression.basic.BasicExpressionProcessor

object ExpressionProvider : BaseDataProvider() {

    override fun getId(): String = "data.expression"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        BasicExpressionProcessor,
    )
}