package feature.auth.base.common.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import shared.presentation.ui.component.DsOutlinedButton
import shared.presentation.ui.icon.DsIconModel

@Composable
internal fun AuthButton(
    modifier: Modifier = Modifier,
    icon: DsIconModel,
    text: String,
    onClick: () -> Unit,
) {
    DsOutlinedButton(
        modifier = modifier,
        iconTint = Color.Unspecified,
        onClick = onClick,
        icon = icon,
        text = text
    )
}