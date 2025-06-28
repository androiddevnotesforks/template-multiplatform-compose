package kotli.template.multiplatform.compose.feature.auth.supabase

import kotli.engine.FeatureProcessor
import kotli.engine.TemplateState
import kotli.template.multiplatform.compose.feature.UserFeatureProcessor
import kotli.template.multiplatform.compose.feature.auth.AuthClientBaseProcessor
import kotli.template.multiplatform.compose.platform.server.supabase.SupabaseProcessor
import kotlin.reflect.KClass

object AuthClientSupabaseProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:auth:client:supabase"

    override val featureName: String = "Supabase"

    override fun getWebUrl(state: TemplateState): String = "https://supabase.com"
    override fun getIntegrationUrl(state: TemplateState): String = "https://supabase.com/docs"

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        AuthClientBaseProcessor::class,
        SupabaseProcessor::class
    )
}