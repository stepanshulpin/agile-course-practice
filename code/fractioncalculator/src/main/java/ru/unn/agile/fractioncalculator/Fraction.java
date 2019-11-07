package ru.unn.agile.fractioncalculator;

import java.util.Objects;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(final int numerator, final int denominator) throws IllegalArgumentException {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator must not be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fraction)) {
            return false;
        }
        var thisReducedFraction = new FractionCalculator(this).reduce();
        var thatReducedFraction = new FractionCalculator((Fraction) o).reduce();
        return thisReducedFraction.numerator == thatReducedFraction.numerator
                && thisReducedFraction.denominator == thatReducedFraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

}
