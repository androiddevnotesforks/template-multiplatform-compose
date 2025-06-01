package feature.common.api.preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface FeatureMethod {

    val name: String

    @Composable
    fun preview()
}