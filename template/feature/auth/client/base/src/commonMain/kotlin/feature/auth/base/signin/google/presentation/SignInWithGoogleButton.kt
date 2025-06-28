package feature.auth.base.signin.google.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import feature.auth.base.common.presentation.AuthButton
import feature.auth.base.common.presentation.AuthIcons
import feature.common.koin.koinFeatureViewModel
import org.jetbrains.compose.resources.stringResource
import template.feature.auth.client.base.generated.resources.Res
import template.feature.auth.client.base.generated.resources.auth_sign_in_google

@Composable
internal fun SignInWithGoogleButton(
    modifier: Modifier = Modifier
) {
    val viewModel: SignInWithGoogleViewModel = koinFeatureViewModel()
    AuthButton(
        modifier = modifier,
        onClick = viewModel::onSignIn,
        text = stringResource(Res.string.auth_sign_in_google),
        icon = AuthIcons.google
    )
}