import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
// 1
fun main() {
    // 2
    application {
        // 3
        val windowState = rememberWindowState()
        // 4
        Window(
            onCloseRequest = ::exitApplication,
            state = windowState,
            title = "App_123654"
        ) {
            // 5
            Surface(modifier = Modifier.fillMaxSize()) {
                // TODO: Add Theme
                // TODO: Add MainView
            }
        }
    }
}