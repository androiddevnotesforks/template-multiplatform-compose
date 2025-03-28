package kotli.app.di.platform

import kotli.app.Application

actual fun createDataStorePath(fileName: String): String {
    val context = Application.instance
    return context.filesDir.resolve(fileName).absolutePath
}