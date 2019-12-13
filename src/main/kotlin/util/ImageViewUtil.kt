package util

import javafx.scene.image.Image
import javafx.scene.image.ImageView
import java.io.FileInputStream

class ImageViewUtil {
    private constructor()

    companion object {

        fun imageViewFromUrl(url: String): ImageView {
            val inputStream = FileInputStream(ImageViewUtil::class.java.classLoader.getResource(url).file)
            val image = Image(inputStream)
            return ImageView(image)
        }
    }
}