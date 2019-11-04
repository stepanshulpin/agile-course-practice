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
}
