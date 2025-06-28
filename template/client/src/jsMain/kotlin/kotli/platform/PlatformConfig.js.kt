package kotli.platform

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import kotli.common.data.source.database.DatabaseSource
import kotli.common.data.source.database.sqldelight.SqlDelightSource
import org.koin.dsl.module
import org.w3c.dom.Worker

actual fun NavGraphBuilder.platform(navController: NavHostController) = Unit

actual val platform = module {
    // {data.database.sqldelight}
    single<DatabaseSource> {
        val driver = WebWorkerDriver(
            Worker(
                js("""new URL("@cashapp/sqldelight-sqljs-worker/sqljs.worker.js", import.meta.url)""")
            )
        )
        SqlDelightSource(driver)
    }
    // {data.database.sqldelight}
}