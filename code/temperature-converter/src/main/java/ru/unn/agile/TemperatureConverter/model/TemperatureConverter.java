package ru.unn.agile.TemperatureConverter.model;

public class TemperatureConverter {
    public DegreeFahrenheit convertCelsiusToFahrenheit(final DegreeCelsius celsius) {
        final double coefficient = 9.0 / 5.0;
        final double shift = 32.0;
        return new DegreeFahrenheit(coefficient * celsius.getTemperature() + shift);
    }
}
