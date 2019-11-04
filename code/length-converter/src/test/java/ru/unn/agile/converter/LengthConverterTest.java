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

    @Test
    public void canConvertMeterToMile() {
        double mile = LengthConverter.meterToMile(10000);
        assertEquals(6.213712, mile, delta);
    }

    @Test
    public void canConvertCentimeterToMeter() {
        double meter = LengthConverter.centimeterToMeter(250);
        assertEquals(2.5, meter, delta);
    }

    @Test
    public void canConvertCentimeterToKilometer() {
        double km = LengthConverter.centimeterToKilometer(35000);
        assertEquals(0.35, km, delta);
    }
}
