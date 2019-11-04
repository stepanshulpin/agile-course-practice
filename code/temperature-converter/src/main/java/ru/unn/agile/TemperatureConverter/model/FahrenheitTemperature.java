package ru.unn.agile.TemperatureConverter.model;

public class FahrenheitTemperature {
    private double value;
    private final double absoluteZero = -459.67;

    public FahrenheitTemperature(final double value) throws IllegalArgumentException {
        if (value < this.absoluteZero) {
            throw new IllegalArgumentException("The temperature is less than absolute zero!");
        }
        this.value = value;
    }

    public FahrenheitTemperature(final String value) {
        this(Double.parseDouble(value));
    }

    public double getValue() {
        return this.value;
    }
}
