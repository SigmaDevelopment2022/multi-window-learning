package window

class DefaultWindowState(val createNewWindow: () -> Unit, private val close: (DefaultWindowState) -> Unit) {
    fun close() {
        close(this)
    }
}