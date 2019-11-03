package ru.unn.agile.TemperatureConverter.Model;

import org.junit.Test;
import ru.unn.agile.TemperatureConverter.model.TemperatureConverter;
import ru.unn.agile.TemperatureConverter.model.DegreeCelsius;
import ru.unn.agile.TemperatureConverter.model.DegreeFahrenheit;

import static org.junit.Assert.*;

public class TemperatureConverterTest {
    private final double delta = 0.001;

    @Test
    public void canConvertCelsius0ToFahrenheit32() {
        TemperatureConverter converter = new TemperatureConverter();
        DegreeCelsius celsius = new DegreeCelsius(0.0);

        DegreeFahrenheit fahrenheit = converter.convertToFahrenheit(celsius);

        assertEquals(32.0, fahrenheit.getTemperature(), delta);
    }

    @Test
    public void canConvertCelsius5ToFahrenheit41() {
        TemperatureConverter converter = new TemperatureConverter();
        DegreeCelsius celsius = new DegreeCelsius(5);

        DegreeFahrenheit fahrenheit = converter.convertToFahrenheit(celsius);

        assertEquals(41.0, fahrenheit.getTemperature(), delta);
    }
}
