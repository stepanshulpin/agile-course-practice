package ru.unn.agile.converter;

import java.util.HashMap;

import static ru.unn.agile.converter.ConverterConstants.*;
import static ru.unn.agile.converter.LengthType.*;

public final class LengthConverter {
    private double value;
    private LengthType type;

    private final HashMap<LengthType, Double> coefficients = new HashMap<>() {{
        put(METER, METER_TO_METER);
        put(CENTIMETER, METER_TO_CENTIMETER);
        put(KILOMETER, METER_TO_KILOMETER);
        put(MILLIMETER, METER_TO_MILLIMETER);
        put(MILE, METER_TO_MILE);
    }};

    public LengthConverter(final double value, final LengthType type) {
        this.value = value;
        this.type = type;
    }

    public double convert(final LengthType type) {
        value = getMeter() * coefficients.get(type);
        this.type = type;
        return value;
    }

    public void setValue(final double value) {
        this.value = value;
    }

    private double getMeter() {
        return value / coefficients.get(type);
    }
}
