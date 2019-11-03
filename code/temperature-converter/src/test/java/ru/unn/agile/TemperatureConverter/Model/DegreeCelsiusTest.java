package ru.unn.agile.TemperatureConverter.Model;

import org.junit.Test;
import ru.unn.agile.TemperatureConverter.model.DegreeCelsius;

import static org.junit.Assert.*;

public class DegreeCelsiusTest {
    private final double delta = 0.001;

    @Test
    public void canCreateDegreeCelsius0() {
        DegreeCelsius celsius = new DegreeCelsius(0.0);

        assertEquals(0.0, celsius.getTemperature(), delta);
    }

    @Test
    public void canCreateDegreeCelsiusFromString() {
        DegreeCelsius celsius = new DegreeCelsius("100.01");

        assertEquals(100.01, celsius.getTemperature(), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateDegreeCelsiusLessAbsoluteZro() {
        DegreeCelsius celsius = new DegreeCelsius(-274.15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotCreateDegreeCelsiusLessAbsoluteZroFromString() {
        DegreeCelsius celsius = new DegreeCelsius("-300.01");
    }

    @Test(expected = NumberFormatException.class)
    public void canNotCreateDegreeCelsiusFromIncorrectString() {
        DegreeCelsius celsius = new DegreeCelsius("abc100.0 1");
    }
}
