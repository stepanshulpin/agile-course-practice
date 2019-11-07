package ru.unn.agile.mortgagecalculator.model;

public class MortgageCalculator {

    private final double FRACTION_OF_HUNDRED = 0.01;

    public double calculateWithoutPayments(double amount, double percent, int years) {
        double oneYearAmount = amount + amount * percent * FRACTION_OF_HUNDRED;
        if(years > 1) {
            return oneYearAmount + oneYearAmount * percent * FRACTION_OF_HUNDRED;
        }
        return oneYearAmount;
    }
}
