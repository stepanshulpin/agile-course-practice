package ru.unn.agile.mortgagecalculator.model;

public class MortgageCalculator {

    private final double FRACTION_OF_HUNDRED = 0.01;
    private final int MONTHS_IN_YEAR = 12;

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

    public double calculateWithDifferentialPayments(double amount, double percent, int years) {
        Validator validator = new Validator();
        validator.checkPositiveInteger(years);
        int months = years * MONTHS_IN_YEAR;
        double monthPercent = percent / MONTHS_IN_YEAR;
        double basicPayment = amount / months;
        double currentAmount = amount;

        double finalAmount = 0;

        while (months > 0) {
            double percentPayment = currentAmount * monthPercent * FRACTION_OF_HUNDRED;
            double payment = basicPayment + percentPayment;
            currentAmount -= basicPayment;
            finalAmount += payment;
            months--;
        }

        return round(finalAmount);
    }
}
