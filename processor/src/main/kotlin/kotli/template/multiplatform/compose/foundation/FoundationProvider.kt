package kotli.template.multiplatform.compose.foundation

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes

abstract class FoundationProvider : BaseFeatureProvider() {

    override fun isRequired(): Boolean = true
    override fun isMultiple(): Boolean = false
    override fun getType(): FeatureType = FeatureTypes.Foundation
}