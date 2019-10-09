package application.view

import application.model.ToolType
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.canvas.Canvas
import javafx.scene.control.ColorPicker
import javafx.scene.control.Slider
import javafx.scene.paint.Color
import tornadofx.*
import util.ImageViewUtil
import java.lang.IllegalStateException
import kotlin.math.abs

class CanvasView : View() {
    private val canvas: Canvas = initializeCanvas()
    private val colorPicker: ColorPicker = initializeColorPicker()
    private val strokeSlider: Slider = initializeSlider()
    private val toolMenu = initializeToolMenu()

    private var currentColor: Color = c("black")
    private var currentStrokeWidth = 10.0

    private var initialPoint = Point(0.0,0.0)
    private var finalPoint = Point(0.0,0.0)
    private var drawingShape = false

    private var currentTool: ToolType = ToolType.PENCIL

    init {
        initializeOnReleasedListener()
        initializeOnDragListener()
    }

    override val root = borderpane {
        left {
            add(toolMenu)
        }

        center {
            add(canvas)
        }

        right {
            vbox {
                add(colorPicker)
                add(strokeSlider)
            }
        }
    }

    private fun drawArc() {
        val context = canvas.graphicsContext2D
        context.fill = currentColor
        context.fillOval(initialPoint.x, initialPoint.y, currentStrokeWidth, currentStrokeWidth)
    }

    private fun drawRectangle() {
        val context = canvas.graphicsContext2D
        val width = abs(initialPoint.x - finalPoint.x)
        val height = abs(initialPoint.y - finalPoint.y)

        context.fill = currentColor
        context.fillRect(initialPoint.x, initialPoint.y, width, height)
    }

    private fun drawCircle() {
        val context = canvas.graphicsContext2D
        val width = abs(initialPoint.x - finalPoint.x)
        val height = abs(initialPoint.y - finalPoint.y)

        context.fill = currentColor
        context.fillOval(initialPoint.x, initialPoint.y, width, height)
    }

    private fun initializeOnDragListener() {
        canvas.setOnMouseReleased {
            if (drawingShape) {
                drawingShape = false
                finalPoint = Point(it.x, it.y)

                when (currentTool) {
                    ToolType.SQUARE -> drawRectangle()
                    ToolType.CIRCLE -> drawCircle()
                    else -> throw IllegalStateException("You messed up, joe. Now, the client is disappointed.")
                }
            }
        }
    }

    private fun initializeOnReleasedListener() {
        canvas.setOnMouseDragged {
            if (!drawingShape) {
                initialPoint = Point(it.x, it.y)

                when (currentTool) {
                    ToolType.PENCIL -> drawArc()
                    ToolType.CIRCLE, ToolType.SQUARE -> drawingShape = true
                    ToolType.ERASER -> {
                        currentColor = Color.WHITE
                        drawArc()
                    }
                }
            }
        }
    }

    private fun initializeToolMenu(): ListMenu {
        return listmenu {
            item {
                graphic = ImageViewUtil.imageViewFromUrl("/Users/prince/Documents/dev/doodle-app/src/main/resources/graphics/toolbar/pencil_ic.png")
                whenSelected { currentTool = ToolType.PENCIL }
            }

            item {
                graphic = ImageViewUtil.imageViewFromUrl("/Users/prince/Documents/dev/doodle-app/src/main/resources/graphics/toolbar/eraser_ic.png")
                whenSelected { currentTool = ToolType.ERASER }
            }

            item {
                graphic = ImageViewUtil.imageViewFromUrl("/Users/prince/Documents/dev/doodle-app/src/main/resources/graphics/toolbar/square_ic.png")
                whenSelected {
                    currentTool = ToolType.SQUARE
                }
            }

            item {
                graphic = ImageViewUtil.imageViewFromUrl("/Users/prince/Documents/dev/doodle-app/src/main/resources/graphics/toolbar/circle_ic.png")
                whenSelected { currentTool = ToolType.CIRCLE }
            }

            item {
                graphic = ImageViewUtil.imageViewFromUrl("/Users/prince/Documents/dev/doodle-app/src/main/resources/graphics/toolbar/trash_ic.png")
                whenSelected {
                    canvas.graphicsContext2D.clearRect(0.0, 0.0, canvas.width, canvas.height)
                }
            }
        }
    }

    private fun initializeCanvas(): Canvas {
        val canvas = Canvas()
        canvas.width = 600.0
        canvas.height = 600.0

        return canvas
    }

    private fun initializeColorPicker(): ColorPicker {
        val colorPicker = colorpicker {
            value = currentColor
        }

        colorPicker.onAction = EventHandler<ActionEvent> { currentColor = colorPicker.value }
        return colorPicker
    }

    private fun initializeSlider(): Slider {
        return slider {
            min = 5.0
            max = 40.0
            valueChangingProperty().addListener(
                ChangeListener { _, _, _ -> currentStrokeWidth = this@slider.value  }
            )
        }
    }

    data class Point(val x: Double, val y: Double)
}


