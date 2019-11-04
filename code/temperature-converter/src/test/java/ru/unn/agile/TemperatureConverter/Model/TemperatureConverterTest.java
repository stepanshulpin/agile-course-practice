package ru.unn.agile.TemperatureConverter.Model;

import org.junit.Test;
import ru.unn.agile.TemperatureConverter.model.CelsiusTemperature;
import ru.unn.agile.TemperatureConverter.model.FahrenheitTemperature;
import ru.unn.agile.TemperatureConverter.model.KelvinTemperature;
import ru.unn.agile.TemperatureConverter.model.NewtonTemperature;
import ru.unn.agile.TemperatureConverter.model.TemperatureConverter;

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

    @Test
    public void canConvertCelsius0ToKelvin273() {
        TemperatureConverter converter = new TemperatureConverter();
        CelsiusTemperature celsius = new CelsiusTemperature(0.0);

        KelvinTemperature kelvin = converter.convertToKelvin(celsius);

        assertEquals(273.15, kelvin.getValue(), delta);
    }

    @Test
    public void canConvertCelsius0ToNewton0() {
        TemperatureConverter converter = new TemperatureConverter();
        CelsiusTemperature celsius = new CelsiusTemperature(0.0);

        NewtonTemperature newton = converter.convertToNewton(celsius);

        assertEquals(0, newton.getValue(), delta);
    }

    @Test
    public void canConvertCelsius33ToNewton10() {
        TemperatureConverter converter = new TemperatureConverter();
        CelsiusTemperature celsius = new CelsiusTemperature(33.0);

        NewtonTemperature newton = converter.convertToNewton(celsius);

        assertEquals(10.89, newton.getValue(), delta);
    }

    @Test
    public void canConvertFahrenheit41ToCelsius5() {
        TemperatureConverter converter = new TemperatureConverter();
        FahrenheitTemperature fahrenheit = new FahrenheitTemperature(41);

        CelsiusTemperature celsius = converter.convertToCelsius(fahrenheit);

        assertEquals(5.0, celsius.getValue(), delta);
    }

    @Test
    public void canConvertFahrenheit10ToKelvin260() {
        TemperatureConverter converter = new TemperatureConverter();
        FahrenheitTemperature fahrenheit = new FahrenheitTemperature(10);

        KelvinTemperature kelvin = converter.convertToKelvin(fahrenheit);

        assertEquals(260.928, kelvin.getValue(), delta);
    }

    @Test
    public void canConvertFahrenheit0ToKelvin255() {
        TemperatureConverter converter = new TemperatureConverter();
        FahrenheitTemperature fahrenheit = new FahrenheitTemperature(0.0);

        KelvinTemperature kelvin = converter.convertToKelvin(fahrenheit);

        assertEquals(255.372, kelvin.getValue(), delta);
    }

    @Test
    public void canConvertFahrenheit32ToNewton0() {
        TemperatureConverter converter = new TemperatureConverter();
        FahrenheitTemperature fahrenheit = new FahrenheitTemperature(32.0);

        NewtonTemperature newton = converter.convertToNewton(fahrenheit);

        assertEquals(0.0, newton.getValue(), delta);
    }

    @Test
    public void canConvertKelvin0ToCelsiumAbsoluteZero() {
        TemperatureConverter converter = new TemperatureConverter();
        KelvinTemperature kelvin = new KelvinTemperature(0.0);

        CelsiusTemperature celsius = converter.convertToCelsius(kelvin);

        assertEquals(-273.15, celsius.getValue(), delta);
    }

    @Test
    public void canConvertKelvin0ToFahrenheitAbsoluteZero() {
        TemperatureConverter converter = new TemperatureConverter();
        KelvinTemperature kelvin = new KelvinTemperature(0.0);

        FahrenheitTemperature fahrenheit = converter.convertToFahrenheit(kelvin);

        assertEquals(-459.67, fahrenheit.getValue(), delta);
    }

    @Test
    public void canConvertKelvin455ToNewton60() {
        TemperatureConverter converter = new TemperatureConverter();
        KelvinTemperature kelvin = new KelvinTemperature(454.97);

        NewtonTemperature newton = converter.convertToNewton(kelvin);

        assertEquals(60.0, newton.getValue(), delta);
    }
}
