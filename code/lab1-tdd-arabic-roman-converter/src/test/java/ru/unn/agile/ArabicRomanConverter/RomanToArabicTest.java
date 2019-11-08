package ru.unn.agile.ArabicRomanConverter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanToArabicTest {

    private int convertToArabic(final String roman) {
        RomanToArabicConverter converter = new RomanToArabicConverter();
        int arabic = converter.convert(roman);
        return arabic;
    }

    @Test
    public void canConvertTo1() {
        int arabic = convertToArabic("I");
        assertEquals(1, arabic);
    }

    @Test
    public void canConvertTo2() {
        int arabic = convertToArabic("II");
        assertEquals(2, arabic);
    }

    @Test
    public void canConvertTo3() {
        int arabic = convertToArabic("III");
        assertEquals(3, arabic);
    }

    @Test
    public void canConvertTo4() {
        int arabic = convertToArabic("IV");
        assertEquals(4, arabic);
    }

    @Test
    public void canConvertTo5() {
        int arabic = convertToArabic("V");
        assertEquals(5, arabic);
    }

    @Test
    public void canConvertTo6() {
        int arabic = convertToArabic("VI");
        assertEquals(6, arabic);
    }

    @Test
    public void canConvertTo10() {
        int arabic = convertToArabic("X");
        assertEquals(10, arabic);
    }

    @Test
    public void canConvertTo9() {
        int arabic = convertToArabic("IX");
        assertEquals(9, arabic);
    }

    @Test
    public void canConvertTo11() {
        int arabic = convertToArabic("XI");
        assertEquals(11, arabic);
    }

    @Test
    public void canConvertTo30() {
        int arabic = convertToArabic("XXX");
        assertEquals(30, arabic);
    }

    @Test
    public void canConvertTo40() {
        int arabic = convertToArabic("XL");
        assertEquals(40, arabic);
    }

    @Test
    public void canConvertTo50() {
        int arabic = convertToArabic("L");
        assertEquals(50, arabic);
    }

    @Test
    public void canConvertTo100() {
        int arabic = convertToArabic("C");
        assertEquals(100, arabic);
    }

    @Test
    public void canConvertTo500() {
        int arabic = convertToArabic("D");
        assertEquals(500, arabic);
    }

    @Test
    public void canConvertTo1000() {
        int arabic = convertToArabic("M");
        assertEquals(1000, arabic);
    }

    @Test
    public void canConvertTo99() {
        int arabic = convertToArabic("XCIX");
        assertEquals(99, arabic);
    }

    @Test
    public void canConvertTo944() {
        int arabic = convertToArabic("CMXLIV");
        assertEquals(944, arabic);
    }

    @Test
    public void canConvertTo444() {
        int arabic = convertToArabic("CDXLIV");
        assertEquals(444, arabic);
    }

    @Test
    public void canConvertTo3999() {
        int arabic = convertToArabic("MMMCMXCIX");
        assertEquals(3999, arabic);
    }
}
