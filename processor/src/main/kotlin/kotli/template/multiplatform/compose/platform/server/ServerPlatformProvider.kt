package kotli.template.multiplatform.compose.platform.server

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes
import kotli.template.multiplatform.compose.platform.server.ktor.KtorProcessor
import kotli.template.multiplatform.compose.platform.server.supabase.SupabaseProcessor

object ServerPlatformProvider : BaseFeatureProvider() {

    override fun getId(): String = "platform.server"
    override fun isRequired(): Boolean = false
    override fun isMultiple(): Boolean = false
    override fun getType(): FeatureType = FeatureTypes.Platform

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        KtorProcessor,
        SupabaseProcessor
    )

}