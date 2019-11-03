package ru.unn.agile.TemperatureConverter.model;

public class TemperatureConverter {
    public double convertCelsiusToFahrenheit(final double celsius) {
        final double coefficient = 9.0 / 5.0;
        final double shift = 32.0;
        return coefficient * celsius + shift;
    }
}
