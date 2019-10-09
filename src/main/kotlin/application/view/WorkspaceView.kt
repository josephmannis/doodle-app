package application.view

import javafx.scene.canvas.Canvas
import tornadofx.*

class WorkspaceView: View() {

    private val canvas: Canvas = initializeCanvas()

    override val root = hbox {
        add(find(ToolButtonsView::class))
        add(find(CanvasView::class))
        add(find(StrokeEditorView::class))
    }


    private fun initializeCanvas(): Canvas {
        val canvas = Canvas()
        canvas.width = 600.0
        canvas.height = 600.0

        return canvas
    }
}