package kotli.template.multiplatform.compose.data.database

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.data.BaseDataProvider
import kotli.template.multiplatform.compose.data.database.room.RoomProcessor
import kotli.template.multiplatform.compose.data.database.sqldelight.SqlDelightProcessor

object DatabaseProvider : BaseDataProvider() {

    override fun getId(): String = "data.database"
    override fun isMultiple(): Boolean = false

    override fun createProcessors(): List<FeatureProcessor> = listOf(
        SqlDelightProcessor,
        RoomProcessor,
        SqliteProcessor,
        SqliteLinkerProcessor,
        DatabaseCommonProcessor
    )

}