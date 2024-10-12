import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.image.BufferedImage
import javax.swing.JPanel

class PixelWindow : JPanel() {
    private val width = 200
    private val height = 200
    private val image: BufferedImage

    init {
        preferredSize = Dimension(width, height)
        // Create a BufferedImage where we will set each pixel
        image = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
        //drawPixels()
    }

    private fun fractal(constant: Complex, nrOfIterations: Int): Double {

        if (nrOfIterations == 1) {
            return 0.0
        }

        var result = Complex(0.0, 0.0)
        for (i in 2..nrOfIterations) {
            result = result.multiply(result).add(constant)
        }

        return result.absolute()
    }

     fun drawPixels(xTranslation : Double, yTranslation  : Double, scaling : Double ) {
        // Loop through each pixel and set a random color
        for (x in 0 until width) {
            for (y in 0 until height) {
                val fractalResult = fractal(Complex((x.toDouble() - width/2) * scaling + xTranslation ,(y.toDouble() - height/2) * scaling + yTranslation) , 100)
                if(fractalResult <= 2.0)
                {
                    image.setRGB(x, y, Color(255,255,255).rgb)
                }
                else
                {
                    image.setRGB(x, y, Color(0,0,0).rgb)
                }
            }
        }
         image.setRGB(width/2, height/2, Color(255,0,0).rgb)
         repaint()
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        // Draw the image onto the panel
        g.drawImage(image, 0, 0, null)
    }
}