package ru.unn.agile.ArabicRomanConverter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanToArabicTest {

    private int ConvertToArabic(final String roman) {
        RomanToArabicConverter converter = new RomanToArabicConverter();
        int arabic = converter.convert(roman);
        return arabic;
    }

    @Test
    public void convert_I_to_1() {
        int arabic = ConvertToArabic("I");
        assertEquals(1, arabic);
    }

    @Test
    public void convert_EmptyString_to_0() {
        int arabic = ConvertToArabic("");
        assertEquals(0, arabic);
    }

    @Test
    public void convert_II_to_2() {
        int arabic = ConvertToArabic("II");
        assertEquals(2, arabic);
    }

    @Test
    public void convert_III_to_3() {
        int arabic = ConvertToArabic("III");
        assertEquals(3, arabic);
    }

    @Test
    public void convert_IV_to_4() {
        int arabic = ConvertToArabic("IV");
        assertEquals(4, arabic);
    }

    @Test
    public void convert_V_to_5() {
        int arabic = ConvertToArabic("V");
        assertEquals(5, arabic);
    }

    @Test
    public void convert_VI_to_6() {
        int arabic = ConvertToArabic("VI");
        assertEquals(6, arabic);
    }

    @Test
    public void convert_X_to_10() {
        int arabic = ConvertToArabic("X");
        assertEquals(10, arabic);
    }

    @Test
    public void convert_IX_to_9() {
        int arabic = ConvertToArabic("IX");
        assertEquals(9, arabic);
    }

    @Test
    public void convert_XI_to_11() {
        int arabic = ConvertToArabic("XI");
        assertEquals(11, arabic);
    }

    @Test
    public void convert_XXX_to_30() {
        int arabic = ConvertToArabic("XXX");
        assertEquals(30, arabic);
    }

    @Test
    public void convert_XL_to_40() {
        int arabic = ConvertToArabic("XL");
        assertEquals(40, arabic);
    }

    @Test
    public void convert_L_to_50() {
        int arabic = ConvertToArabic("L");
        assertEquals(50, arabic);
    }

    @Test
    public void convert_C_to_100() {
        int arabic = ConvertToArabic("C");
        assertEquals(100, arabic);
    }

    @Test
    public void convert_D_to_500() {
        int arabic = ConvertToArabic("D");
        assertEquals(500, arabic);
    }

    @Test
    public void convert_M_to_1000() {
        int arabic = ConvertToArabic("M");
        assertEquals(1000, arabic);
    }

    @Test
    public void convert_XCIX_to_99() {
        int arabic = ConvertToArabic("XCIX");
        assertEquals(99, arabic);
    }

    @Test
    public void convert_CMXLIV_to_944() {
        int arabic = ConvertToArabic("CMXLIV");
        assertEquals(944, arabic);
    }

    @Test
    public void convert_CDXLIV_to_444() {
        int arabic = ConvertToArabic("CDXLIV");
        assertEquals(444, arabic);
    }

    @Test
    public void convert_MMMCMXCIX_to_3999() {
        int arabic = ConvertToArabic("MMMCMXCIX");
        assertEquals(3999, arabic);
    }
}
