package ru.unn.agile.converter;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthConverterTest {

    private final double delta = 0.001;

    @Test
    public void canConvertMeterToCentimeter() {
        LengthConverter converter = new LengthConverter(5, LengthType.METER);
        double cm = converter.convert(LengthType.CENTIMETER);
        assertEquals(500, cm, delta);
    }

    @Test
    public void canConvertMeterToKilometer() {
        LengthConverter converter = new LengthConverter(5000, LengthType.METER);
        double km = converter.convert(LengthType.KILOMETER);
        assertEquals(5, km, delta);
    }

    @Test
    public void canConvertMeterToMillimeter() {
        LengthConverter converter = new LengthConverter(2, LengthType.METER);
        double mm = converter.convert(LengthType.MILLIMETER);
        assertEquals(2000, mm, delta);
    }

    @Test
    public void canConvertMeterToMile() {
        LengthConverter converter = new LengthConverter(10000, LengthType.METER);
        double mile = converter.convert(LengthType.MILE);
        assertEquals(6.213712, mile, delta);
    }

    @Test
    public void canConvertCentimeterToMeter() {
        LengthConverter converter = new LengthConverter(250, LengthType.CENTIMETER);
        double meter = converter.convert(LengthType.METER);
        assertEquals(2.5, meter, delta);
    }

    @Test
    public void canConvertCentimeterToKilometer() {
        LengthConverter converter = new LengthConverter(35000, LengthType.CENTIMETER);
        double km = converter.convert(LengthType.KILOMETER);
        assertEquals(0.35, km, delta);
    }
}
