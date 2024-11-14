package kotli.app.feature.showcases.presentation.dataflow.room.crud

import kotli.app.feature.showcases.domain.Showcase
import kotlinx.serialization.Serializable

@Serializable
object RoomCrudRoute {

    val screen = Showcase.Screen("Room CRUD", this)

}