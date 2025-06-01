package kotli.template.multiplatform.compose.ui

import kotli.engine.BaseFeatureProvider
import kotli.engine.FeatureType
import kotli.engine.model.FeatureTypes

abstract class UiProvider : BaseFeatureProvider() {

    final override fun getType(): FeatureType = FeatureTypes.UiLayer
}