package kotli.app.navigation.a.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import shared.presentation.ui.component.DsText
import shared.presentation.viewmodel.provideViewModel

@Composable
fun AScreen() {
    val viewModel: AViewModel = provideViewModel()
    val state = viewModel.state

    Box(Modifier.fillMaxSize()) {
        DsText(
            modifier = Modifier.align(Alignment.Center),
            text = state.title
        )
    }
}