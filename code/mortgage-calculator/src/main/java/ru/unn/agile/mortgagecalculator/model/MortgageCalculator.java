package ru.unn.agile.mortgagecalculator.model;

public class MortgageCalculator {

    private final double FRACTION_OF_HUNDRED = 0.01;

    public double calculateWithoutPayments(double amount, double percent, int years) {
        Validator validator = new Validator();
        validator.checkPositiveInteger(years);
        double finalAmount = amount;
        while (years > 0) {
            finalAmount = finalAmount + round(finalAmount * percent * FRACTION_OF_HUNDRED);
            years--;
        }
        return finalAmount;
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
