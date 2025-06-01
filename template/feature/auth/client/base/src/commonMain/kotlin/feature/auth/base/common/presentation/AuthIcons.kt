package feature.auth.base.common.presentation

import shared.presentation.ui.icon.DsIconModel
import template.feature.auth.client.base.generated.resources.Res
import template.feature.auth.client.base.generated.resources.auth_email
import template.feature.auth.client.base.generated.resources.auth_google

object AuthIcons {
    val email: DsIconModel
        get() = DsIconModel.DrawableResource(Res.drawable.auth_email)
    val google: DsIconModel
        get() = DsIconModel.DrawableResource(Res.drawable.auth_google)
}