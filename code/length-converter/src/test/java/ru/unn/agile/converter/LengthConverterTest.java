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

    @Test
    public void canConvertMeterToKilometer() {
        double km = LengthConverter.meterToKilometer(5000);
        assertEquals(5, km, delta);
    }

    @Test
    public void canConvertMeterToMillimeter() {
        double mm = LengthConverter.meterToMillimeter(2);
        assertEquals(2000, mm, delta);
    }
}
