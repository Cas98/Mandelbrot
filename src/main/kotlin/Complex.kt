class Complex(val real: Double, val imaginary: Double) {
    fun add(other: Complex): Complex {
        return Complex(real + other.real, imaginary + other.imaginary)
    }

    fun multiply(other: Complex): Complex {

        return Complex(real * other.real - imaginary * other.imaginary, imaginary*other.real + other.imaginary*real)
    }

    fun absolute(): Double {
        return Math.sqrt(real * real + imaginary * imaginary)
    }


    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Complex

        if (real != other.real) return false
        return imaginary == other.imaginary
    }

    override fun toString(): String {
        return "Complex(real=$real, imaginary=$imaginary)"
    }


}