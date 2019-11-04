package ru.unn.agile.TemperatureConverter.model;

class ConverterCelsiusFahrenheit {
    CelsiusTemperature convertToCelsius(final FahrenheitTemperature fahrenheit) {
        final double coefficient = 5.0 / 9.0;
        final double shift = 32.0;
        return new CelsiusTemperature(coefficient * (fahrenheit.getValue() - shift));
    }

    FahrenheitTemperature convertToFahrenheit(final CelsiusTemperature celsius) {
        final double coefficient = 9.0 / 5.0;
        final double shift = 32.0;
        return new FahrenheitTemperature(coefficient * celsius.getValue() + shift);
    }
}
