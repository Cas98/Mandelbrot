import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame

fun fractal(constant: Complex, nrOfIterations: Int): Double {

    if (nrOfIterations == 1) {
        return 0.0
    }

    var result = Complex(0.0, 0.0)
    for (i in 2..nrOfIterations) {
        result = result.multiply(result).add(constant)
    }

    return result.absolute()
}

fun main(args: Array<String>) {
    // Create a JFrame to hold the panel
    val frame = JFrame("Pixel Drawing Window")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

    // Add our custom PixelWindow panel to the frame
    val pixelWindow = PixelWindow()
    frame.add(pixelWindow)


    // Pack the frame and make it visible
    frame.pack()
    frame.isVisible = true

    var isRunning = true
    var xTranslation = 0.0
    var yTranslation = 0.0
    var scaling = 0.01
    var movementSpeed = 1.0
    val scaleMultiplier = 0.1
    var deltaTime = 0.0
    // Add a key listener to the frame
    frame.addKeyListener(object : KeyListener {
        override fun keyTyped(e: KeyEvent?) {}

        override fun keyPressed(e: KeyEvent?) {
            if (e?.keyCode == KeyEvent.VK_Q) {
                isRunning = false
                println("Q key is pressed, isKeyPressed set to false")
            }
            if (e?.keyCode == KeyEvent.VK_W) {
                yTranslation -= movementSpeed * deltaTime
                println("Q key is pressed, isKeyPressed set to false")
            }
            if (e?.keyCode == KeyEvent.VK_S) {
                yTranslation += movementSpeed * deltaTime
                println("Q key is pressed, isKeyPressed set to false")
            }
            if (e?.keyCode == KeyEvent.VK_A) {
                xTranslation -= movementSpeed * deltaTime
                println("Q key is pressed, isKeyPressed set to false")
            }
            if (e?.keyCode == KeyEvent.VK_D) {
                xTranslation += movementSpeed * deltaTime
                println("Q key is pressed, isKeyPressed set to false")
            }
            if (e?.keyCode == KeyEvent.VK_Z) {
                scaling *= (1.0 - scaleMultiplier)
                movementSpeed *= (1.0 - scaleMultiplier)
                println("Q key is pressed, isKeyPressed set to false")
            }
            if (e?.keyCode == KeyEvent.VK_X) {
                scaling *= (1.0 + scaleMultiplier)
                movementSpeed *= (1.0 + scaleMultiplier)
                println("Q key is pressed, isKeyPressed set to false")
            }
        }

        override fun keyReleased(e: KeyEvent?) {}
    })



    while(isRunning)
    {
        val startTime = System.currentTimeMillis()
        pixelWindow.drawPixels(xTranslation,yTranslation,scaling)
        val endTime = System.currentTimeMillis()
        deltaTime = (endTime - startTime).toDouble() / 1000.0
        println(deltaTime.toString())
    }
}