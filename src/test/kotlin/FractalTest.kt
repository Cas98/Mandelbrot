import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FractalTest {

    @Test
    fun fractal() {
        assertEquals(fractal(Complex(0.0,0.0), 1), 0.0)
        assertEquals(fractal(Complex(1.0,0.0), 1), 0.0)

        assertEquals(fractal(Complex(1.0,0.0), 2), 1.0)
        assertEquals(fractal(Complex(2.0,0.0), 2), 2.0)

        assertEquals(fractal(Complex(1.0,0.0), 3), 2.0)
        assertEquals(fractal(Complex(2.0,0.0), 3), 6.0)

        assertEquals(fractal(Complex(1.0,0.0), 4), 5.0)

        assertEquals(fractal(Complex(0.0,1.0), 2), 1.0)
        assertEquals(fractal(Complex(0.0,1.0), 3), Math.sqrt(2.0))

        //        assertEquals(fractal(2.0, 2), 2.0)
        //assertEquals(fractal(1.0, 1), 0.0)
        //assertEquals(fractal(.0), 0.0)
    }
}