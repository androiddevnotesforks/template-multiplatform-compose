package kotli.template.multiplatform.compose.feature.auth

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProvider
import kotli.template.multiplatform.compose.feature.auth.stub.AuthClientStubProcessor
import kotli.template.multiplatform.compose.feature.auth.supabase.AuthClientSupabaseProcessor

object AuthFeatureProvider : UserFeatureProvider() {

    override fun getId(): String = "feature.auth"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        AuthClientApiProcessor,
        AuthClientBaseProcessor,
        AuthClientStubProcessor,
        AuthClientSupabaseProcessor
    )
}