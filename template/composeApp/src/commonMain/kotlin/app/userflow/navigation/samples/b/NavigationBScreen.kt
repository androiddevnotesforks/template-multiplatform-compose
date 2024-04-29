package app.userflow.navigation.samples.b

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.appViewModel

@Composable
fun NavigationBScreen() {
    val viewModel: NavigationBViewModel = appViewModel()
    Box(Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "B"
        )
    }
}