import androidx.compose.runtime.key
import androidx.compose.ui.window.application
import window.DefaultWindow
import window.rememberApplicationState

fun main() = application {
    val applicationState = rememberApplicationState()

    applicationState.windowsStates.value.forEach { defaultWindowState ->
        key(defaultWindowState){
            DefaultWindow(defaultWindowState)
        }
    }
}