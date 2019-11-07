package ru.unn.agile.fractioncalculator;

import java.util.Objects;

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

    public FractionCalculator reduce() {
        var tmpNumerator = numerator;
        var tmpDenominator = denominator;
        while (tmpNumerator != 0 && tmpDenominator != 0) {
            if (tmpNumerator > tmpDenominator) {
                tmpNumerator %= tmpDenominator;
            } else {
                tmpDenominator %= tmpNumerator;
            }
        }
        var nod = tmpNumerator + tmpDenominator;
        return new FractionCalculator(numerator / nod, denominator / nod);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FractionCalculator that = (FractionCalculator) o;
        return numerator == that.numerator
                && denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}
