package ru.unn.agile.ArabicRomanConverter;

public class ArabicToRomanConverter {

    private static final int[] ARABIC_NUMERALS = {1000, 900, 500, 400,
            100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD",
            "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public ArabicToRomanConverter() { };

    public String convert(final int arabicNumber) {

        StringBuilder romanNumber = new StringBuilder();
        int arabic = arabicNumber;
        for (int i = 0; i < ARABIC_NUMERALS.length; i++) {
            while (arabic >= ARABIC_NUMERALS[i]) {
                romanNumber.append(ROMAN_NUMERALS[i]);
                arabic -= ARABIC_NUMERALS[i];
            }
        }
        return romanNumber.toString();
    }
}
