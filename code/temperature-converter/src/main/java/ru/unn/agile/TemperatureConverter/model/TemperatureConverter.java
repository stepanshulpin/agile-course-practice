package ru.unn.agile.TemperatureConverter.model;

public class TemperatureConverter {
    public FahrenheitTemperature convertToFahrenheit(final CelsiusTemperature celsius) {
        final double coefficient = 9.0 / 5.0;
        final double shift = 32.0;
        return new FahrenheitTemperature(coefficient * celsius.getValue() + shift);
    }

    public KelvinTemperature convertToKelvin(final CelsiusTemperature celsius) {
        final double shift =  273.15;
        return new KelvinTemperature(celsius.getValue() + shift);
    }

    public NewtonTemperature convertToNewton(final CelsiusTemperature celsius) {
        final double coefficient = 33.0 / 100.0;
        return new NewtonTemperature(coefficient * celsius.getValue());
    }

    public CelsiusTemperature convertToCelsius(final FahrenheitTemperature fahrenheit) {
        final double coefficient = 5.0 / 9.0;
        final double shift = 32.0;
        return new CelsiusTemperature(coefficient * (fahrenheit.getValue() - shift));
    }

    public KelvinTemperature convertToKelvin(final FahrenheitTemperature fahrenheit) {
        final CelsiusTemperature celsius = convertToCelsius(fahrenheit);
        return convertToKelvin(celsius);
    }

    public NewtonTemperature convertToNewton(final FahrenheitTemperature fahrenheit) {
        final CelsiusTemperature celsius = convertToCelsius(fahrenheit);
        return convertToNewton(celsius);
    }

    public CelsiusTemperature convertToCelsius(final KelvinTemperature kelvin) {
        final double shift = 273.15;
        return new CelsiusTemperature(kelvin.getValue() - shift);
    }

    public FahrenheitTemperature convertToFahrenheit(final KelvinTemperature kelvin) {
        final CelsiusTemperature celsius = convertToCelsius(kelvin);
        return convertToFahrenheit(celsius);
    }

    public NewtonTemperature convertToNewton(final KelvinTemperature kelvin) {
        final CelsiusTemperature celsius = convertToCelsius(kelvin);
        return convertToNewton(celsius);
    }

    public CelsiusTemperature convertToCelsius(final NewtonTemperature newton) {
        final double coefficient = 100.0 / 33.0;
        return new CelsiusTemperature(coefficient * newton.getValue());
    }

    public FahrenheitTemperature convertToFahrenheit(final NewtonTemperature newton) {
        final CelsiusTemperature celsius = convertToCelsius(newton);
        return convertToFahrenheit(celsius);
    }
}
