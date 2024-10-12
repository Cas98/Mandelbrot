import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ComplexTest {

    @Test
    fun add() {
        assertEquals(Complex(0.0, 0.0), Complex(0.0, 0.0).add(Complex(0.0, 0.0)))
        assertEquals(Complex(1.0, 1.0), Complex(0.0, 0.0).add(Complex(1.0, 1.0)))
        assertEquals(Complex(2.0, 2.0), Complex(1.0, 1.0).add(Complex(1.0, 1.0)))
        assertEquals(Complex(9.0, 7.0), Complex(2.0, 3.0).add(Complex(7.0, 4.0)))
    }

    @Test
    fun multiply() {
        assertEquals(Complex(0.0, 0.0), Complex(0.0, 0.0).multiply(Complex(0.0, 0.0)))
        assertEquals(
            Complex(1.0 * 3.0 - 2.0 * 4.0, 2.0 * 3.0 + 4.0 * 1.0),
            Complex(1.0, 2.0).multiply(Complex(3.0, 4.0))
        )

    }

    @Test
    fun absolute() {
        assertEquals(0.0, Complex(0.0, 0.0).absolute())
        assertEquals(5.0, Complex(3.0, 4.0).absolute())

    }
}