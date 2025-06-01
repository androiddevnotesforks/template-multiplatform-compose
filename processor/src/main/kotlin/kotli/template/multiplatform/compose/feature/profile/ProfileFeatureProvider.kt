package kotli.template.multiplatform.compose.feature.profile

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProvider
import kotli.template.multiplatform.compose.feature.profile.stub.ProfileClientStubProcessor

object ProfileFeatureProvider : UserFeatureProvider() {

    override fun getId(): String = "feature.profile"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        ProfileClientApiProcessor,
        ProfileClientStubProcessor
    )
}