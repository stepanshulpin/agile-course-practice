package ru.unn.agile.converter;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthConverterTest {

    private final double delta = 0.001;

    @Test
    public void canConvertMeterToCentimeter() {
        double cm = LengthConverter.meterToCentimeter(5);
        assertEquals(500, cm, delta);
    }
}
