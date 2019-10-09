package application.controller

import application.model.FillType
import application.model.ToolType
import javafx.event.Event
import javafx.event.EventHandler
import javafx.scene.shape.Shape
import tornadofx.Controller

interface DoodleControllerType {
    fun changeColor(fill: FillType)
    fun changeTool(tool: ToolType)
    fun changeStroke(width: Double)
    fun addCanvasElement(shape: Shape)
    fun clearCanvas()
}

class DoodleController : Controller(), EventHandler<Event> {
    override fun handle(event: Event?) {

    }
}


