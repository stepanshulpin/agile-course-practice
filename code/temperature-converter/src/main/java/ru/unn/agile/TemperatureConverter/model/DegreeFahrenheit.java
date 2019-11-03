package ru.unn.agile.TemperatureConverter.model;

public class DegreeFahrenheit {
    private double temperature;
    private final double absoluteZero = -459.67;

    public DegreeFahrenheit(final double temperature) throws IllegalArgumentException {
        if (temperature < this.absoluteZero) {
            throw new IllegalArgumentException("The temperature is less than absolute zero!");
        }
        this.temperature = temperature;
    }

    public DegreeFahrenheit(final String temperature) {
        this(Double.parseDouble(temperature));
    }

    public double getTemperature() {
        return this.temperature;
    }
}
