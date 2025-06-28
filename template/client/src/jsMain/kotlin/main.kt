import androidx.compose.ui.window.CanvasBasedWindow
import kotli.app.presentation.App
import org.jetbrains.skiko.wasm.onWasmReady

fun main() = onWasmReady {
    CanvasBasedWindow(canvasElementId = "appTarget") {
        App()
    }
}