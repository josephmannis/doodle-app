package application.view

import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class StrokeEditorView : View() {
    override val root = vbox {
        this.style {
            borderColor += box(all = Color.BLACK)
            arcHeight = 20.px
            arcWidth = 20.px
        }

        text {

            style {
                fontSize = 22.px
                fontWeight = FontWeight.BOLD
                textFill = c("#3C99F6")
            }

            text = "Tools"
        }

        text {

            style {
                fontSize = 18.px
            }

            text = "Color:"
        }

        text {
            style {
                fontSize = 18.px
            }

            text = "Stroke:"
        }

        slider {
            isSnapToTicks = true
            min = 1.0
            max = 30.0
        }
    }
}