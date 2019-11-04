package ru.unn.agile.TemperatureConverter.Model;

import org.junit.Test;
import ru.unn.agile.TemperatureConverter.model.FahrenheitTemperature;

import static org.junit.Assert.assertEquals;

public class FahrenheitTemperatureTest {
    private final double delta = 0.001;

    @Test
    public void canCreateDegreeFahrenheit0() {
        FahrenheitTemperature fahrenheit = new FahrenheitTemperature(0.0);

        assertEquals(0.0, fahrenheit.getValue(), delta);
    }

    @Test
    public void canCreateDegreeCelsiusFromString() {
        FahrenheitTemperature celsius = new FahrenheitTemperature("100.01");

        assertEquals(100.01, celsius.getValue(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateDegreeCelsiusLessAbsoluteZro() {
        FahrenheitTemperature celsius = new FahrenheitTemperature(-500.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateDegreeCelsiusLessAbsoluteZroFromString() {
        FahrenheitTemperature celsius = new FahrenheitTemperature("-500.01");
    }

    @Test(expected = NumberFormatException.class)
    public void canNotCreateDegreeCelsiusFromIncorrectString() {
        FahrenheitTemperature celsius = new FahrenheitTemperature("abc100.0 1");
    }
}
