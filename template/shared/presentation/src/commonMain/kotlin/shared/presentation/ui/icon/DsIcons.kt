package shared.presentation.ui.icon

import template.shared.presentation.generated.resources.Res
import template.shared.presentation.generated.resources.ic_arrow_back
import template.shared.presentation.generated.resources.ic_cancel

object DsIcons {

    val cancel: DsIconModel
        get() = DsIconModel.DrawableResource(Res.drawable.ic_cancel)
    val arrowBack: DsIconModel
        get() = DsIconModel.DrawableResource(Res.drawable.ic_arrow_back)
}