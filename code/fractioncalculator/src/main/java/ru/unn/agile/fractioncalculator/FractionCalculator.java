package ru.unn.agile.fractioncalculator;

public class FractionCalculator {

    private Fraction fraction;

    public FractionCalculator(final Fraction fraction) {
        this.fraction = fraction;
    }

    public Fraction getFraction() {
        return fraction;
    }

    public Fraction reduce() {
        var tmpNumerator = fraction.getNumerator();
        var tmpDenominator = fraction.getDenominator();
        while (tmpNumerator != 0 && tmpDenominator != 0) {
            if (tmpNumerator > tmpDenominator) {
                tmpNumerator %= tmpDenominator;
            } else {
                tmpDenominator %= tmpNumerator;
            }
        }
        var nod = tmpNumerator + tmpDenominator;
        return new Fraction(
                fraction.getNumerator() / nod,
                fraction.getDenominator() / nod
        );
    }
}
