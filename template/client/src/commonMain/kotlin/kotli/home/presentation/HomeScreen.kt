package kotli.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotli.getViewModel
import shared.presentation.ui.component.DsText

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = getViewModel()
    val state = viewModel.state

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        DsText(text = "Home Screen")
    }
}