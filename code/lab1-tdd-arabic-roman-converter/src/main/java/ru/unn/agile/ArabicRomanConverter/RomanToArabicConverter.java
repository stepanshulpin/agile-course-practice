package ru.unn.agile.ArabicRomanConverter;

import java.util.Hashtable;

public class RomanToArabicConverter {

    private Hashtable<Character, Integer> ht;

    public RomanToArabicConverter() {
        ht = new Hashtable<>();
        ht.put('I', 1);
        ht.put('V', 5);
        ht.put('X', 10);
        ht.put('L', 50);
        ht.put('C', 100);
        ht.put('D', 500);
        ht.put('M', 1000);
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
