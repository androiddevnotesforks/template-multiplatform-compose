package feature.passcode.basic.presentation.set

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import feature.common.koin.koinFeatureViewModel
import feature.passcode.basic.presentation.common.PasscodeKeyboard
import org.jetbrains.compose.resources.stringResource
import shared.presentation.state.UiState
import shared.presentation.state.ViewStateHandler
import shared.presentation.ui.component.DsCircularProgressIndicator
import shared.presentation.ui.container.DsFixedTopBarColumn

@Composable
internal fun SetPasscodeScreen(
    onBack: () -> Unit
) {
    val viewModel: SetPasscodeViewModel = koinFeatureViewModel()
    val state = viewModel.state
    val step = state.step

    ViewStateHandler(
        state = state,
        onEvent = { event ->
            when (event) {
                is SetPasscodeState.OnComplete -> onBack()
            }
        },
        content = {
            DsFixedTopBarColumn(
                onBack = onBack
            ) {
                when (state.uiState) {
                    UiState.Loading -> {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            DsCircularProgressIndicator()
                        }
                    }

                    else -> {
                        PasscodeKeyboard(
                            onCodeChange = viewModel::onEnter,
                            title = step?.titleRes?.let { stringResource(it) },
                            codeLength = state.passcodeLength,
                            getCode = state::enteredCode,
                            getError = state::error,
                        )
                    }
                }
            }
        }
    )
}