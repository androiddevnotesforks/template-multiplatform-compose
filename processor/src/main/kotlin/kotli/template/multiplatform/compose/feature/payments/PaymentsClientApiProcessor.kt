package kotli.template.multiplatform.compose.feature.payments

import kotli.template.multiplatform.compose.feature.UserFeatureProcessor

object PaymentsClientApiProcessor : UserFeatureProcessor() {

    override val moduleName: String = "feature:payments:client:api"

    override val featureName: String = "PaymentsFeature"

    override fun isInternal(): Boolean = true
}