package kotli.app.presentation

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import feature.common.api.Feature

@Stable
interface AppState {
    val start: Any?
    val features: List<Feature>
    fun setStartDestination(start: Any)
}

class AppMutableState(override val features: List<Feature>) : AppState {
    override var start: Any? by mutableStateOf(null)
    override fun setStartDestination(start: Any) = this::start.set(start)
}