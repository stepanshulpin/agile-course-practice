package ru.unn.agile.mortgagecalculator.model;

public class MortgageCalculator {

    public double calculateWithoutPayments(MortgageParameters parameters) {

        int months = parameters.getMonthsPeriod();
        double monthPercent = parameters.getMonthPercent();
        double percent = parameters.getFractionPercent();
        double finalAmount = parameters.getAmount();
        while (months >= 12) {
            finalAmount = finalAmount + round(finalAmount * percent);
            months -= 12;
        }
        finalAmount = finalAmount + round(finalAmount * monthPercent * months);
        return finalAmount;

    }

    public MortgageReport calculateWithDifferentialPayments(MortgageParameters parameters) {

        int months = parameters.getMonthsPeriod();
        double monthPercent = parameters.getMonthPercent();
        double basicPayment = parameters.getAmount() / months;
        double currentAmount = parameters.getAmount();

        MortgageReport report = new MortgageReport(parameters.getAmount());

        double finalAmount = 0;

        while (months > 0) {
            double percentPayment = currentAmount * monthPercent;
            double payment = basicPayment + percentPayment;
            currentAmount -= basicPayment;
            finalAmount += payment;

            MortgageMonthReport monthReport = new MortgageMonthReport(payment, basicPayment, percentPayment, currentAmount);
            report.add(monthReport);

            months--;
        }

        report.setFinalAmount(round(finalAmount));

        return report;

    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
