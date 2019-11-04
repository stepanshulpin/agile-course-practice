package ru.unn.agile.converter;

public final class LengthConverter {
    private static final double METER_TO_CENTIMETER_COEFF = 100;

    private LengthConverter() {
    }

    public static double meterToCentimeter(final double meter) {
        return meter * METER_TO_CENTIMETER_COEFF;
    }
}
