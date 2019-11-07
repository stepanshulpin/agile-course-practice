package ru.unn.agile.fractioncalculator;

import java.util.Objects;

public class Fraction {

    private int numerator;
    private int denominator;

    private static final String FRACTION_DELIMITER = "/";

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
    public String toString() {
        return numerator + FRACTION_DELIMITER + denominator;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fraction)) {
            return false;
        }
        var thisReducedFraction = FractionCalculator.reduce(this);
        var thatReducedFraction = FractionCalculator.reduce((Fraction) o);
        return thisReducedFraction.numerator == thatReducedFraction.numerator
                && thisReducedFraction.denominator == thatReducedFraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

}
