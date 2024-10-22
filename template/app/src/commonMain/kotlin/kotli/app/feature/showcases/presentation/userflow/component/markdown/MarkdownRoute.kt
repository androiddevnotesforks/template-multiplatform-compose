package kotli.app.feature.showcases.presentation.userflow.component.markdown

import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object MarkdownRoute {

    val screen = Showcase.Screen("Markdown Text", this)

}