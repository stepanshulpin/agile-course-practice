package ru.unn.agile.TemperatureConverter.model;

public class CelsiusTemperature {
    private double value;
    private final double absoluteZero = -273.15;

    public CelsiusTemperature(final double value) throws IllegalArgumentException {
        if (value < this.absoluteZero) {
            throw new IllegalArgumentException("The temperature is less than absolute zero!");
        }
        this.value = value;
    }

    public CelsiusTemperature(final String value) {
        this(Double.parseDouble(value));
    }

    public double getValue() {
        return this.value;
    }
}
