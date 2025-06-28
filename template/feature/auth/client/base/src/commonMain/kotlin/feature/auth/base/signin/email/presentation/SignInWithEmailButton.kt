package feature.auth.base.signin.email.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import feature.auth.base.common.presentation.AuthIcons
import org.jetbrains.compose.resources.stringResource
import shared.presentation.ui.component.DsOutlinedButton
import template.feature.auth.client.base.generated.resources.Res
import template.feature.auth.client.base.generated.resources.auth_sign_in_email

@Composable
internal fun SignInWithEmailButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    DsOutlinedButton(
        modifier = modifier,
        icon = AuthIcons.email,
        text = stringResource(Res.string.auth_sign_in_email),
        onClick = onClick,
    )
}