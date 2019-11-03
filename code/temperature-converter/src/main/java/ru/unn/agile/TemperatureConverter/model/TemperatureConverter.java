package ru.unn.agile.TemperatureConverter.model;

public class TemperatureConverter {
    public double convertCelsiusToFahrenheit(double celsius) {
        double coefficient = 9.0 / 5.0;
        double shift = 32.0;
        return coefficient * celsius + shift;
    }
}
