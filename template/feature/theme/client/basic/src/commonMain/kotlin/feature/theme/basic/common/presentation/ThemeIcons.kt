package feature.theme.basic.common.presentation

import shared.presentation.ui.icon.DsIconModel
import template.feature.theme.client.basic.generated.resources.Res
import template.feature.theme.client.basic.generated.resources.ic_dark_mode
import template.feature.theme.client.basic.generated.resources.ic_light_mode

object ThemeIcons {
    val dark
        get() = DsIconModel.DrawableResource(Res.drawable.ic_dark_mode)
    val light
        get() = DsIconModel.DrawableResource(Res.drawable.ic_light_mode)
}