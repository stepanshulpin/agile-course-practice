package ru.unn.agile.mortgagecalculator.model;

public class MortgageCalculator {

    private final double FRACTION_OF_HUNDRED = 0.01;
    private final int MONTHS_IN_YEAR = 12;

    public double calculateWithoutPayments(double amount, double percent, PeriodType periodType, int period) {
        Validator validator = new Validator();
        validator.checkPositiveInteger(period);
        int months = getMonths(periodType, period);
        double monthPercent = percent / MONTHS_IN_YEAR;
        double finalAmount = amount;
        while (months >= 12) {
            finalAmount = finalAmount + round(finalAmount * percent * FRACTION_OF_HUNDRED);
            months-= 12;
        }
        finalAmount = finalAmount + round(finalAmount * monthPercent * months * FRACTION_OF_HUNDRED);
        return finalAmount;
    }

    public double calculateWithDifferentialPayments(double amount, double percent, PeriodType periodType, int period) {
        Validator validator = new Validator();
        validator.checkPositiveInteger(period);
        int months = getMonths(periodType, period);
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

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    private int getMonths(PeriodType periodType, int period) {
        if (PeriodType.MONTH.equals(periodType)) {
            return period;
        } else {
            return period * MONTHS_IN_YEAR;
        }
    }
}
