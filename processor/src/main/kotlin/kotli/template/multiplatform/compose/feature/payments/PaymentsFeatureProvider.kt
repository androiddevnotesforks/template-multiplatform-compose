package kotli.template.multiplatform.compose.feature.payments

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.feature.UserFeatureProvider
import kotli.template.multiplatform.compose.feature.payments.revenuecat.PaymentsClientRevenueCatProcessor

object PaymentsFeatureProvider : UserFeatureProvider() {

    override fun getId(): String = "feature.payments"

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        PaymentsClientApiProcessor,
        PaymentsClientRevenueCatProcessor
    )
}