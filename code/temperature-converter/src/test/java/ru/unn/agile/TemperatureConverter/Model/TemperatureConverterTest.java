package ru.unn.agile.TemperatureConverter.Model;

import org.junit.Test;
import ru.unn.agile.TemperatureConverter.model.TemperatureConverter;

import static org.junit.Assert.*;

public class TemperatureConverterTest {
    private final double delta = 0.001;

    @Test
    public void canConvertCelsius0ToFahrenheit32() {
        double celsius = 0.0;
        TemperatureConverter converter = new TemperatureConverter();

        double fahrenheit = converter.convertCelsiusToFahrenheit(celsius);

        assertEquals(32.0, fahrenheit, delta);
    }
}
