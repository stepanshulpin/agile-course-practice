package ru.unn.agile.TemperatureConverter.model;

public class CelsiusTemperature extends Temperature {
    @Override
    protected double getAbsoluteZero() {
        final double absoluteZero = -273.15;
        return absoluteZero;
    }

    public CelsiusTemperature(final double value) throws IllegalArgumentException {
        super(value);
    }

    public CelsiusTemperature(final String value) {
        super(value);
    }
}
