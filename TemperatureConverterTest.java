import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TempConvProgramTest {

    private static final double EPSILON = 1e-6; // avoids rounding issues in double comparisons

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, TempConvProgramTestHelper.convertCelsiusToFahrenheit(0.0), EPSILON);
        assertEquals(212.0, TempConvProgramTestHelper.convertCelsiusToFahrenheit(100.0), EPSILON);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, TempConvProgramTestHelper.convertFahrenheitToCelsius(32.0), EPSILON);
        assertEquals(100.0, TempConvProgramTestHelper.convertFahrenheitToCelsius(212.0), EPSILON);
    }

    @Test
    void testCelsiusToKelvin() {
        assertEquals(273.15, TempConvProgramTestHelper.convertCelsiusToKelvin(0.0), EPSILON);
        assertEquals(310.15, TempConvProgramTestHelper.convertCelsiusToKelvin(37.0), EPSILON);
    }
}

class TempConvProgramTestHelper {
    // helper class isolates logic for testing, maintaining single responsibility
    static double convertCelsiusToFahrenheit(double c) { return c * 9.0 / 5.0 + 32.0; }
    static double convertFahrenheitToCelsius(double f) { return (f - 32.0) * 5.0 / 9.0; }
    static double convertCelsiusToKelvin(double c) { return c + 273.15; }
}
