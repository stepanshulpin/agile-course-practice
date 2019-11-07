package ru.unn.agile.fractioncalculator;

public class FractionCalculator {

    private int numerator;
    private int denominator;

    public FractionCalculator(final int numerator, final int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int reduce() {
        return 1;
    }
}
