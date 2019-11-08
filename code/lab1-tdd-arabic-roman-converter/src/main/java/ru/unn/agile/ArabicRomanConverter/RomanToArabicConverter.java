package ru.unn.agile.ArabicRomanConverter;

import java.util.Hashtable;

public class RomanToArabicConverter {

    private static final int[] ARABIC_NUMERALS = {1, 5, 10, 50,
            100, 500, 1000};
    private Hashtable<Character, Integer> ht;

    public RomanToArabicConverter() {
        ht = new Hashtable<>();
        ht.put('I', ARABIC_NUMERALS[0]);
        ht.put('V', ARABIC_NUMERALS[1]);
        ht.put('X', ARABIC_NUMERALS[2]);
        ht.put('L', ARABIC_NUMERALS[3]);
        ht.put('C', ARABIC_NUMERALS[4]);
        ht.put('D', ARABIC_NUMERALS[5]);
        ht.put('M', ARABIC_NUMERALS[6]);
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
