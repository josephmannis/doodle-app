package application.model

import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleListProperty
import javafx.geometry.Point2D
import javafx.scene.paint.Color
import javafx.scene.shape.Shape
import tornadofx.ItemViewModel
import tornadofx.px

interface CanvasType {
    fun changeColor(fill: FillType)
    fun changeTool(tool: ToolType)
    fun changeStroke(width: Double)
    fun addCanvasElement(shape: Shape)
    fun clearCanvas()
}


data class ShapeModel(val shape: Shape, val position: Point, val color: Color)

data class Point(val x: Double, val y: Double)

enum class ToolType {
    PENCIL,
    ERASER,
    SQUARE,
    CIRCLE,
    LINE
}

enum class FillType(color: Color) {
    RED(Color.RED),
    ORANGE(Color.ORANGE),
    YELLOW(Color.LIGHTYELLOW),
    GREEN(Color.LIGHTSEAGREEN),
    TURQUOISE(Color.TURQUOISE),
    PERIWINKLE(Color.CADETBLUE),
    LAVENDER(Color.LAVENDER),
    PINK(Color.PINK),
    MAGENTA(Color.HOTPINK),
    GRAY(Color.GRAY),
    BLACK(Color.BLACK),
    WHITE(Color.WHITE)
}

