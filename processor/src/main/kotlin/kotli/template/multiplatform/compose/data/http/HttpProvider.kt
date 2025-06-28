package kotli.template.multiplatform.compose.data.http

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.data.BaseDataProvider
import kotli.template.multiplatform.compose.data.http.ktor.KtorHttpProcessor

object HttpProvider : BaseDataProvider() {

    override fun getId(): String = "data.http"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        KtorHttpProcessor
    )
}