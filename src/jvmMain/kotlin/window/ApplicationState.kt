package window

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable

class ApplicationState {
    private var _windowsStates = mutableStateListOf<DefaultWindowState>()
    val windowsStates = derivedStateOf { _windowsStates }

    init {
        _windowsStates += defaultWindowState()
    }

    fun createNewWindow() {
        _windowsStates += defaultWindowState()
    }

    private fun defaultWindowState(): DefaultWindowState =
        DefaultWindowState(close = _windowsStates::remove, createNewWindow = ::createNewWindow)
}

@Composable
fun rememberApplicationState() = rememberSaveable { ApplicationState() }