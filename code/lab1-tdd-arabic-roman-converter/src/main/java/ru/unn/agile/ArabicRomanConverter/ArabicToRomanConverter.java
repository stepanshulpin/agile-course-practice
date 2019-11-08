package ru.unn.agile.ArabicRomanConverter;

public class ArabicToRomanConverter {

    private static final int[] arabic_numerals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] roman_numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public ArabicToRomanConverter(){};

    public String Convert(int arabicNumber) {

        StringBuilder romanNumber = new StringBuilder();

        for (int i = 0; i < arabic_numerals.length; i++) {
            while (arabicNumber >= arabic_numerals[i]) {
                romanNumber.append(roman_numerals[i]);
                arabicNumber -= arabic_numerals[i];
            }
        }
        return romanNumber.toString();
    }
}
