package ru.unn.agile.TemperatureConverter.Model;

import org.junit.Test;
import ru.unn.agile.TemperatureConverter.model.TemperatureConverter;
import ru.unn.agile.TemperatureConverter.model.CelsiusTemperature;
import ru.unn.agile.TemperatureConverter.model.FahrenheitTemperature;

import static org.junit.Assert.*;

public class TemperatureConverterTest {
    private final double delta = 0.001;

    @Test
    public void canConvertCelsius0ToFahrenheit32() {
        TemperatureConverter converter = new TemperatureConverter();
        CelsiusTemperature celsius = new CelsiusTemperature(0.0);

        FahrenheitTemperature fahrenheit = converter.convertToFahrenheit(celsius);

        assertEquals(32.0, fahrenheit.getValue(), delta);
    }

    @Test
    public void canConvertCelsius5ToFahrenheit41() {
        TemperatureConverter converter = new TemperatureConverter();
        CelsiusTemperature celsius = new CelsiusTemperature(5);

        FahrenheitTemperature fahrenheit = converter.convertToFahrenheit(celsius);

        assertEquals(41.0, fahrenheit.getValue(), delta);
    }
}
