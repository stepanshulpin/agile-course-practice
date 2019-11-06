package ru.unn.agile.converter;

import java.util.HashMap;

import static ru.unn.agile.converter.ConverterConstants.*;
import static ru.unn.agile.converter.LengthType.*;

public class LengthConverter {
    private double value;
    private LengthType type;

    private final HashMap<LengthType, Double> converterCoefficients = new HashMap<>() {{
        put(METER, METER_TO_METER);
        put(CENTIMETER, METER_TO_CENTIMETER);
        put(KILOMETER, METER_TO_KILOMETER);
        put(MILLIMETER, METER_TO_MILLIMETER);
        put(MILE, METER_TO_MILE);
        put(YARD, METER_TO_YARD);
        put(INCH, METER_TO_INCH);
        put(FOOT, METER_TO_FOOT);
        put(NAUTICAL_MILE, METER_TO_NAUTICAL_MILE);
    }};

    public LengthConverter(final double value, final LengthType type) {
        this.value = value;
        this.type = type;
    }

    public LengthConverter(final double value) {
        this.value = value;
        this.type = LengthType.METER;
    }

    public double convert(final LengthType type) {
        if (!this.type.equals(type)) {
            value = convertToMeter() * converterCoefficients.get(type);
            this.type = type;
        }
        return value;
    }

    public void setValue(final double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public LengthType getType() {
        return type;
    }

    private double convertToMeter() {
        return value / converterCoefficients.get(type);
    }

    public void setType(final LengthType type) {
        this.type = type;
    }
}
