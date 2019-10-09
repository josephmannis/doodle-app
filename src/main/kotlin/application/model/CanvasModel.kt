package application.model

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

//class CanvasModel : CanvasType {
//    private var canvasElements = SimpleListProperty<ShapeModel>()
//    private var currentTool = ToolType.PENCIL
//    private var currentFill = FillType.BLACK
//    private var currentStrokeWidth = 10.px
//
//    override fun changeColor(fill: FillType) {
//        currentFill = fill
//    }
//
//    override fun changeTool(tool: ToolType) {
//        currentTool = tool
//    }
//
//    override fun changeStroke(width: Double) {
//        if (width > 0 && width < 150) {
//            currentStrokeWidth = width.px
//        }
//    }
//
//    override fun addCanvasElement(shape: Shape, point2D: Point2D) {
//        canvasElements.add(shape)
//    }
//
//    override fun clearCanvas() {
//        canvasElements = SimpleListProperty()
//    }
//}

//class CanvasViewModel : ItemViewModel<CanvasModel>() {
//
//}

data class ShapeModel(val shape: Shape, val position: Point2D)

enum class ToolType {
    PENCIL,
    ERASER,
    SQUARE,
    CIRCLE
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

