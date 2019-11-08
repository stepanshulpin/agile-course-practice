package ru.unn.agile.ArabicRomanConverter;

import java.util.Hashtable;

public class RomanToArabicConverter {

    private static final int[] ARABIC_NUMERALS = {1, 5, 10, 50,
            100, 500, 1000};
    private static final Character[] ROMAN_NUMERALS = {'I', 'V', 'X',
            'L', 'C', 'D', 'M'};
    private Hashtable<Character, Integer> ht;

    public RomanToArabicConverter() {
        ht = new Hashtable<>();
        for (int i = 0; i < ARABIC_NUMERALS.length; i++)
            ht.put(ROMAN_NUMERALS[i], ARABIC_NUMERALS[i]);
    }

    public int convert(final String romanNumber) {
        int arabicNumber = 0;
        int prevSymbol = 0;
        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            int currentSymbol = ht.get(romanNumber.charAt(i));
            if (currentSymbol < prevSymbol) {
                arabicNumber -= currentSymbol;
            } else {
                arabicNumber += currentSymbol;
            }
            prevSymbol = currentSymbol;
        }
        return arabicNumber;
    }
}
