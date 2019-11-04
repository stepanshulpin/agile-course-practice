package ru.unn.agile.TemperatureConverter.model;

public class KelvinTemperature extends Temperature {
    @Override
    protected double getAbsoluteZero() {
        final double absoluteZero = 0.0;
        return absoluteZero;
    }

    public KelvinTemperature(final double value) throws IllegalArgumentException {
        super(value);
    }

    public KelvinTemperature(final String value) {
        super(value);
    }
}
