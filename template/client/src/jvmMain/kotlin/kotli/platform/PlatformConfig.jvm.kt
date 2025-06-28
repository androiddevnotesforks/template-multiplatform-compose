package kotli.platform

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.room.Room
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import kotli.common.data.source.database.DatabaseSource
import kotli.common.data.source.database.room.RoomDb
import kotli.common.data.source.database.room.RoomSource
import kotli.common.data.source.database.sqldelight.SqlDelightSource
import org.koin.dsl.module
import shared.data.source.settings.SettingsSource
import shared.data.source.settings.datastore.DataStoreSource
import java.io.File

actual fun NavGraphBuilder.platform(navController: NavHostController) = Unit

actual val platform = module {
    // {data.database.room}
    single<DatabaseSource> {
        val dbName = "app.db"
        val dbFile = File(System.getProperty("java.io.tmpdir"), dbName)
        val dbBuilder = Room.databaseBuilder<RoomDb>(dbFile.absolutePath)
        RoomSource(dbBuilder)
    }
    // {data.database.room}
    // {data.database.sqldelight}
    single<DatabaseSource> {
        val dbName = "app.db"
        val driver = JdbcSqliteDriver("jdbc:sqlite:${dbName}")
        SqlDelightSource(driver)
    }
    // {data.database.sqldelight}
    // {data.settings.datastore}
    single<SettingsSource> {
        val fileName = "app.preferences_pb"
        val file = File(System.getProperty("java.io.tmpdir"), fileName)
        DataStoreSource(file.absolutePath)
    }
    // {data.settings.datastore}
}