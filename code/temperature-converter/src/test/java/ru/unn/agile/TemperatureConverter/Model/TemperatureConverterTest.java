package ru.unn.agile.TemperatureConverter.Model;

import org.junit.Test;
import ru.unn.agile.TemperatureConverter.model.TemperatureConverter;

import static org.junit.Assert.*;

public class TemperatureConverterTest {
    private final double delta = 0.001;

    @Test
    public void canConvertCelsius0ToFahrenheit32() {
        TemperatureConverter converter = new TemperatureConverter();

        double fahrenheit = converter.convertCelsiusToFahrenheit(0.0);

        assertEquals(32.0, fahrenheit, delta);
    }

    @Test
    public void canConvertCelsius5ToFahrenheit41() {
        TemperatureConverter converter = new TemperatureConverter();

        double fahrenheit = converter.convertCelsiusToFahrenheit(5.0);

        assertEquals(41.0, fahrenheit, delta);
    }
}
