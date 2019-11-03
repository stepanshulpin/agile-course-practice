package ru.unn.agile.TemperatureConverter.Model;

import org.junit.Test;
import ru.unn.agile.TemperatureConverter.model.DegreeFahrenheit;

import static org.junit.Assert.assertEquals;

public class DegreesFahrenheitTest {
    private final double delta = 0.001;

    @Test
    public void canCreateDegreeFahrenheit0() {
        DegreeFahrenheit fahrenheit = new DegreeFahrenheit(0.0);

        assertEquals(0.0, fahrenheit.getTemperature(), delta);
    }

    @Test
    public void canCreateDegreeCelsiusFromString() {
        DegreeFahrenheit celsius = new DegreeFahrenheit("100.01");

        assertEquals(100.01, celsius.getTemperature(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateDegreeCelsiusLessAbsoluteZro() {
        DegreeFahrenheit celsius = new DegreeFahrenheit(-500.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateDegreeCelsiusLessAbsoluteZroFromString() {
        DegreeFahrenheit celsius = new DegreeFahrenheit("-500.01");
    }

    @Test(expected = NumberFormatException.class)
    public void canNotCreateDegreeCelsiusFromIncorrectString() {
        DegreeFahrenheit celsius = new DegreeFahrenheit("abc100.0 1");
    }
}
