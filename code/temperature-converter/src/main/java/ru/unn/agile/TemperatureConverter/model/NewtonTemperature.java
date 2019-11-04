package ru.unn.agile.TemperatureConverter.model;

public class NewtonTemperature extends Temperature {
    @Override
    protected double getAbsoluteZero() {
        final double absoluteZero = -90.14;
        return absoluteZero;
    }

    public NewtonTemperature(final double value) throws IllegalArgumentException {
        super(value);
    }

    public NewtonTemperature(final String value) {
        super(value);
    }
}
