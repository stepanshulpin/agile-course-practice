package ru.unn.agile.arabicromanconverter;

import org.junit.Test;
import ru.unn.agile.arabicromanconverter.model.RomanToArabicConverter;

import static org.junit.Assert.assertEquals;

public class RomanToArabicTest {

    private String convertToArabic(final String romanNumber) {
        RomanToArabicConverter converter = new RomanToArabicConverter();
        String arabicNumber = converter.convert(romanNumber);
        return arabicNumber;
    }

    @Test
    public void canConvertTo1() {
        String arabicNumber = convertToArabic("I");
        assertEquals("1", arabicNumber);
    }

    @Test
    public void canConvertTo2() {
        String arabicNumber = convertToArabic("II");
        assertEquals("2", arabicNumber);
    }

    @Test
    public void canConvertTo3() {
        String arabicNumber = convertToArabic("III");
        assertEquals("3", arabicNumber);
    }

    @Test
    public void canConvertTo4() {
        String arabicNumber = convertToArabic("IV");
        assertEquals("4", arabicNumber);
    }

    @Test
    public void canConvertTo5() {
        String arabicNumber = convertToArabic("V");
        assertEquals("5", arabicNumber);
    }

    @Test
    public void canConvertTo6() {
        String arabicNumber = convertToArabic("VI");
        assertEquals("6", arabicNumber);
    }

    @Test
    public void canConvertTo10() {
        String arabicNumber = convertToArabic("X");
        assertEquals("10", arabicNumber);
    }

    @Test
    public void canConvertTo9() {
        String arabicNumber = convertToArabic("IX");
        assertEquals("9", arabicNumber);
    }

    @Test
    public void canConvertTo11() {
        String arabicNumber = convertToArabic("XI");
        assertEquals("11", arabicNumber);
    }

    @Test
    public void canConvertTo30() {
        String arabicNumber = convertToArabic("XXX");
        assertEquals("30", arabicNumber);
    }

    @Test
    public void canConvertTo40() {
        String arabicNumber = convertToArabic("XL");
        assertEquals("40", arabicNumber);
    }

    @Test
    public void canConvertTo50() {
        String arabicNumber = convertToArabic("L");
        assertEquals("50", arabicNumber);
    }

    @Test
    public void canConvertTo100() {
        String arabicNumber = convertToArabic("C");
        assertEquals("100", arabicNumber);
    }

    @Test
    public void canConvertTo500() {
        String arabicNumber = convertToArabic("D");
        assertEquals("500", arabicNumber);
    }

    @Test
    public void canConvertTo1000() {
        String arabicNumber = convertToArabic("M");
        assertEquals("1000", arabicNumber);
    }

    @Test
    public void canConvertTo99() {
        String arabicNumber = convertToArabic("XCIX");
        assertEquals("99", arabicNumber);
    }

    @Test
    public void canConvertTo944() {
        String arabicNumber = convertToArabic("CMXLIV");
        assertEquals("944", arabicNumber);
    }

    @Test
    public void canConvertTo444() {
        String arabicNumber = convertToArabic("CDXLIV");
        assertEquals("444", arabicNumber);
    }

    @Test
    public void canConvertTo3999() {
        String arabicNumber = convertToArabic("MMMCMXCIX");
        assertEquals("3999", arabicNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canConvertTo4000() {
        String arabicNumber = convertToArabic("MMMM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void canConvertWrongRomanValue() {
        String arabicNumber = convertToArabic("IIII");
    }

    @Test(expected = IllegalArgumentException.class)
    public void canConvertIllegalValue() {
        String arabicNumber = convertToArabic("BUGAGASHENKA");
    }
}
