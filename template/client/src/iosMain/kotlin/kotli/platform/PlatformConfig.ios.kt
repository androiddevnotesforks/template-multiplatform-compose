package kotli.platform

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.room.Room
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import kotli.common.data.source.database.DatabaseSource
import kotli.common.data.source.database.room.RoomSource
import kotli.common.data.source.database.sqldelight.SqlDelightDb
import kotli.common.data.source.database.sqldelight.SqlDelightSource
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSHomeDirectory
import platform.Foundation.NSUserDomainMask
import shared.data.source.settings.SettingsSource
import shared.data.source.settings.datastore.DataStoreSource
import kotli.common.data.source.database.room.RoomDb as RoomDatabase

actual fun NavGraphBuilder.platform(navController: NavHostController) = Unit

actual val platform = module {
    // {data.database.room}
    single<DatabaseSource> {
        val dbName = "app.db"
        val dbFilePath = NSHomeDirectory() + "/$dbName"
        val dbBuilder = Room.databaseBuilder<RoomDatabase>(dbFilePath)
        RoomSource(dbBuilder)
    }
    // {data.database.room}
    // {data.database.sqldelight}
    single<DatabaseSource> {
        val dbName = "app.db"
        val driver = NativeSqliteDriver(SqlDelightDb.Schema.synchronous(), dbName)
        SqlDelightSource(driver)
    }
    // {data.database.sqldelight}
    // {data.settings.datastore}
    single<SettingsSource> {
        val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
        val fileName = "app.preferences_pb"
        val directory = requireNotNull(documentDirectory).path
        val path = "${directory}/$fileName"
        DataStoreSource(path)
    }
    // {data.settings.datastore}
}