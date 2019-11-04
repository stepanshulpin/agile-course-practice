package ru.unn.agile.TemperatureConverter.model;

public class TemperatureConverter {
    public FahrenheitTemperature convertToFahrenheit(final CelsiusTemperature celsius) {
        final double coefficient = 9.0 / 5.0;
        final double shift = 32.0;
        return new FahrenheitTemperature(coefficient * celsius.getValue() + shift);
    }

    public KelvinTemperature convertToKelvin(CelsiusTemperature celsius) {
        final double shift =  273.15;
        return new KelvinTemperature(celsius.getValue() + shift);
    }
}
