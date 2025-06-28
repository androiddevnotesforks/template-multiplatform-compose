package kotli.template.multiplatform.compose.feature

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes
import kotli.template.multiplatform.compose.feature.common.CommonClientApiProcessor
import kotli.template.multiplatform.compose.feature.common.CommonClientKoinProcessor
import kotlin.reflect.KClass

abstract class UserFeatureProvider : BaseFeatureProvider() {

    override fun isMultiple(): Boolean = false

    final override fun getType(): FeatureType = FeatureTypes.Feature

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        CommonClientApiProcessor::class,
        CommonClientKoinProcessor::class
    )
}