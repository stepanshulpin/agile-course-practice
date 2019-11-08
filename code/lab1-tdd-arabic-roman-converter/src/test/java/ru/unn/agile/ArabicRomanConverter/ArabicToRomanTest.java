package ru.unn.agile.ArabicRomanConverter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArabicToRomanTest {

    private String convertToRoman(int arabic) {
        ArabicToRomanConverter converter = new ArabicToRomanConverter();
        return converter.Convert(arabic);
    }

    @Test
    public void Convert_0_To_EmptyString() {
        String romanNumber = convertToRoman(0);
        assertEquals("", romanNumber);
    }

    @Test
    public void Convert_1_to_I() {
        String romanNumber = convertToRoman(1);
        assertEquals("I", romanNumber);
    }

    @Test
    public void Convert_2_to_II() {
        String romanNumber = convertToRoman(2);
        assertEquals("II", romanNumber);
    }

    @Test
    public void Convert_3_to_III() {
        String romanNumber = convertToRoman(3);
        assertEquals("III", romanNumber);
    }

    @Test
    public void Convert_5_to_V() {
        String romanNumber = convertToRoman(5);
        assertEquals("V", romanNumber);
    }

    @Test
    public void Convert_6_to_VI() {
        String romanNumber = convertToRoman(6);
        assertEquals("VI", romanNumber);
    }

    @Test
    public void Convert_8_to_VIII() {
        String romanNumber = convertToRoman(8);
        assertEquals("VIII", romanNumber);
    }

    @Test
    public void Convert_4_to_IV() {
        String romanNumber = convertToRoman(4);
        assertEquals("IV", romanNumber);
    }

    @Test
    public void Convert_10_to_X() {
        String romanNumber = convertToRoman(10);
        assertEquals("X", romanNumber);
    }

    @Test
    public void Convert_11_to_XI() {
        String romanNumber = convertToRoman(11);
        assertEquals("XI", romanNumber);
    }

    @Test
    public void Convert_9_to_IX() {
        String romanNumber = convertToRoman(9);
        assertEquals("IX", romanNumber);
    }

    @Test
    public void Convert_30_to_XXX() {
        String romanNumber = convertToRoman(30);
        assertEquals("XXX", romanNumber);
    }

    @Test
    public void Convert_40_to_XL() {
        String romanNumber = convertToRoman(40);
        assertEquals("XL", romanNumber);
    }

    @Test
    public void Convert_50_to_L() {
        String romanNumber = convertToRoman(50);
        assertEquals("L", romanNumber);
    }

    @Test
    public void Convert_70_to_LXX() {
        String romanNumber = convertToRoman(70);
        assertEquals("LXX", romanNumber);
    }

    @Test
    public void Convert_100_to_C() {
        String romanNumber = convertToRoman(100);
        assertEquals("C", romanNumber);
    }

    @Test
    public void Convert_90_to_XC() {
        String romanNumber = convertToRoman(90);
        assertEquals("XC", romanNumber);
    }

    @Test
    public void Convert_500_to_D() {
        String romanNumber = convertToRoman(500);
        assertEquals("D", romanNumber);
    }

    @Test
    public void Convert_400_to_CD() {
        String romanNumber = convertToRoman(400);
        assertEquals("CD", romanNumber);
    }

    @Test
    public void Convert_100_to_M() {
        String romanNumber = convertToRoman(1000);
        assertEquals("M", romanNumber);
    }

    @Test
    public void Convert_900_to_CM() {
        String romanNumber = convertToRoman(900);
        assertEquals("CM", romanNumber);
    }

    @Test
    public void Convert_1974_to_MCMLXXIV() {
        String romanNumber = convertToRoman(1974);
        assertEquals("MCMLXXIV", romanNumber);
    }

    @Test
    public void Convert_655_to_DCLV() {
        String romanNumber = convertToRoman(655);
        assertEquals("DCLV", romanNumber);
    }

    @Test
    public void Convert_3999_to_MMMCMXCIX() {
        String romanNumber = convertToRoman(3999);
        assertEquals("MMMCMXCIX", romanNumber);
    }
}
