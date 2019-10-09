package application.view

import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.vbox
import util.ImageViewUtil

class ToolButtonsView : View() {


    override val root = vbox {
        button(
            graphic =
            ImageViewUtil
                .imageViewFromUrl("/Users/prince/Documents/dev/doodle-app/src/main/resources/graphics/toolbar/pencil_ic.png")
        ).action {

        }

        button(
            graphic =
            ImageViewUtil
                .imageViewFromUrl("/Users/prince/Documents/dev/doodle-app/src/main/resources/graphics/toolbar/eraser_ic.png")
        ).action {
            println("Eraser Selected")
        }

        button(
            graphic =
            ImageViewUtil
                .imageViewFromUrl("/Users/prince/Documents/dev/doodle-app/src/main/resources/graphics/toolbar/circle_ic.png")
        ).action {
            println("Circle Selected")
        }

        button(
            graphic =
            ImageViewUtil
                .imageViewFromUrl("/Users/prince/Documents/dev/doodle-app/src/main/resources/graphics/toolbar/square_ic.png")
        ).action {
            println("Square Selected")
        }

        button(
            graphic =
            ImageViewUtil
                .imageViewFromUrl("/Users/prince/Documents/dev/doodle-app/src/main/resources/graphics/toolbar/line_ic.png")
        ).action {
            println("Line Selected")
        }

        button(
            graphic =
            ImageViewUtil
                .imageViewFromUrl("/Users/prince/Documents/dev/doodle-app/src/main/resources/graphics/toolbar/trash_ic.png")
        ).action {
            println("Trash Selected")
        }
    }
}