package ru.unn.agile.ArabicRomanConverter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArabicToRomanTest {

    private String convertToRoman(final int arabic) {
        ArabicToRomanConverter converter = new ArabicToRomanConverter();
        return converter.convert(arabic);
    }

    @Test
    public void convert_0_to_EmptyString() {
        String romanNumber = convertToRoman(0);
        assertEquals("", romanNumber);
    }

    @Test
    public void convert_1_to_I() {
        String romanNumber = convertToRoman(1);
        assertEquals("I", romanNumber);
    }

    @Test
    public void convert_2_to_II() {
        String romanNumber = convertToRoman(2);
        assertEquals("II", romanNumber);
    }

    @Test
    public void convert_3_to_III() {
        String romanNumber = convertToRoman(3);
        assertEquals("III", romanNumber);
    }

    @Test
    public void convert_5_to_V() {
        String romanNumber = convertToRoman(5);
        assertEquals("V", romanNumber);
    }

    @Test
    public void convert_6_to_VI() {
        String romanNumber = convertToRoman(6);
        assertEquals("VI", romanNumber);
    }

    @Test
    public void convert_8_to_VIII() {
        String romanNumber = convertToRoman(8);
        assertEquals("VIII", romanNumber);
    }

    @Test
    public void convert_4_to_IV() {
        String romanNumber = convertToRoman(4);
        assertEquals("IV", romanNumber);
    }

    @Test
    public void convert_10_to_X() {
        String romanNumber = convertToRoman(10);
        assertEquals("X", romanNumber);
    }

    @Test
    public void convert_11_to_XI() {
        String romanNumber = convertToRoman(11);
        assertEquals("XI", romanNumber);
    }

    @Test
    public void convert_9_to_IX() {
        String romanNumber = convertToRoman(9);
        assertEquals("IX", romanNumber);
    }

    @Test
    public void convert_30_to_XXX() {
        String romanNumber = convertToRoman(30);
        assertEquals("XXX", romanNumber);
    }

    @Test
    public void convert_40_to_XL() {
        String romanNumber = convertToRoman(40);
        assertEquals("XL", romanNumber);
    }

    @Test
    public void convert_50_to_L() {
        String romanNumber = convertToRoman(50);
        assertEquals("L", romanNumber);
    }

    @Test
    public void convert_70_to_LXX() {
        String romanNumber = convertToRoman(70);
        assertEquals("LXX", romanNumber);
    }

    @Test
    public void convert_100_to_C() {
        String romanNumber = convertToRoman(100);
        assertEquals("C", romanNumber);
    }

    @Test
    public void convert_90_to_XC() {
        String romanNumber = convertToRoman(90);
        assertEquals("XC", romanNumber);
    }

    @Test
    public void convert_500_to_D() {
        String romanNumber = convertToRoman(500);
        assertEquals("D", romanNumber);
    }

    @Test
    public void convert_400_to_CD() {
        String romanNumber = convertToRoman(400);
        assertEquals("CD", romanNumber);
    }

    @Test
    public void convert_100_to_M() {
        String romanNumber = convertToRoman(1000);
        assertEquals("M", romanNumber);
    }

    @Test
    public void convert_900_to_CM() {
        String romanNumber = convertToRoman(900);
        assertEquals("CM", romanNumber);
    }

    @Test
    public void convert_1974_to_MCMLXXIV() {
        String romanNumber = convertToRoman(1974);
        assertEquals("MCMLXXIV", romanNumber);
    }

    @Test
    public void convert_655_to_DCLV() {
        String romanNumber = convertToRoman(655);
        assertEquals("DCLV", romanNumber);
    }

    @Test
    public void convert_3999_to_MMMCMXCIX() {
        String romanNumber = convertToRoman(3999);
        assertEquals("MMMCMXCIX", romanNumber);
    }
}
