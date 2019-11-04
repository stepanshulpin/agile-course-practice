package ru.unn.agile.converter;

public final class LengthConverter {
    private static final double METER_TO_CENTIMETER_COEFF = 100;
    private static final double METER_TO_KILOMETER_COEFF = 1000;
    private static final double METER_TO_MILLIMETER_COEFF = 1000;

    private LengthConverter() {
    }

    public static double meterToCentimeter(final double meter) {
        return meter * METER_TO_CENTIMETER_COEFF;
    }

    public static double meterToKilometer(final double meter) {
        return meter / METER_TO_KILOMETER_COEFF;
    }

    public static double meterToMillimeter(final double meter) {
        return meter * METER_TO_MILLIMETER_COEFF;
    }
}
