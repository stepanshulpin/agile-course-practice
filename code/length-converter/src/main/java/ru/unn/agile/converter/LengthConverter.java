package ru.unn.agile.converter;

public final class LengthConverter {
    private LengthConverter() {
    }

    private static double convert(final double value, final double constant) {
        return value * constant;
    }

    public static double meterToCentimeter(final double meter) {
        return convert(meter, ConverterConstants.METER_TO_CENTIMETER);
    }

    public static double meterToKilometer(final double meter) {
        return convert(meter, ConverterConstants.METER_TO_KILOMETER);
    }

    public static double meterToMillimeter(final double meter) {
        return convert(meter, ConverterConstants.METER_TO_MILLIMETER);
    }
}
