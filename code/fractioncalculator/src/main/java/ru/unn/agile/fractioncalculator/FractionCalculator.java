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
        var tmpNumerator = Math.abs(fraction.getNumerator());
        var tmpDenominator = Math.abs(fraction.getDenominator());
        while (tmpNumerator != 0 && tmpDenominator != 0) {
            if (tmpNumerator > tmpDenominator) {
                tmpNumerator %= tmpDenominator;
            } else {
                tmpDenominator %= tmpNumerator;
            }
        }
        var nod = tmpNumerator + tmpDenominator;
        if (fraction.getDenominator() < 0 && fraction.getNumerator() < 0) {
            nod *= -1;
        }
        return new Fraction(
                fraction.getNumerator() / nod,
                fraction.getDenominator() / nod
        );
    }
}
