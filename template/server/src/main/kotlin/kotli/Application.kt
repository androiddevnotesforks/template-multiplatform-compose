package kotli

import io.ktor.server.application.Application
import kotli.plugins.configureRouting
import kotli.plugins.configureCors
import kotli.plugins.configureSerialization
import kotli.plugins.configureSinglePageApplication

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSinglePageApplication()
    configureSerialization()
    configureRouting()
    configureCors()
}
