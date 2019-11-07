package ru.unn.agile.mortgagecalculator.model;

public class MortgageCalculator {

    private final double FRACTION_OF_HUNDRED = 0.01;

    public double calculateWithoutPayments(double amount, double percent) {
        return amount + amount * percent * FRACTION_OF_HUNDRED;
    }
}
