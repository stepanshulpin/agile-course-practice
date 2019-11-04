package ru.unn.agile.TemperatureConverter.model;

public abstract class Temperature {
    private double value;

    protected abstract double getAbsoluteZero();

    Temperature(final double value) throws IllegalArgumentException {
        if (value < getAbsoluteZero()) {
            throw new IllegalArgumentException("The temperature is less than absolute zero!");
        }
        this.value = value;
    }

    Temperature(final String value) {
        this(Double.parseDouble(value));
    }

    public double getValue() {
        return this.value;
    }
}
