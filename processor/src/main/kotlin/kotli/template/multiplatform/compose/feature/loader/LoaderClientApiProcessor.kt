package kotli.template.multiplatform.compose.feature.loader

import kotli.template.multiplatform.compose.feature.UserFeatureProcessor

object LoaderClientApiProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:loader:client:api"

    override val featureName: String = "LoaderFeature"

    override fun isInternal(): Boolean = true
}