package ru.unn.agile.mortgagecalculator.model;

public class MortgageCalculator {

    private final double FRACTION_OF_HUNDRED = 0.01;

    public double calculateWithoutPayments(double i, double i1) {
        return i + i * i1 * FRACTION_OF_HUNDRED;
    }
}
