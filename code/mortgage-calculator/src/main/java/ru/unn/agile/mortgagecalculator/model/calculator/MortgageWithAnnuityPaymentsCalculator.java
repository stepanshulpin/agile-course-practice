package ru.unn.agile.mortgagecalculator.model.calculator;

import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;
import ru.unn.agile.mortgagecalculator.model.report.MortgageMonthReport;
import ru.unn.agile.mortgagecalculator.model.report.MortgageReport;

public class MortgageWithAnnuityPaymentsCalculator extends MortgageCalculator {

    @Override
    public MortgageReport calculate(MortgageParameters parameters) {
        int months = parameters.getMonthsPeriod();
        double monthPercent = parameters.getMonthPercent();
        double annuityPayment = parameters.getAmount() * (monthPercent + monthPercent / (Math.pow(1 + monthPercent, months) - 1));
        double currentAmount = parameters.getAmount();

        MortgageReport report = new MortgageReport(parameters.getAmount());

        while (months > 0) {
            double percentPayment = currentAmount * monthPercent;
            double basicPayment = annuityPayment - percentPayment;
            currentAmount -= basicPayment;
            MortgageMonthReport monthReport = new MortgageMonthReport(round(annuityPayment), round(basicPayment), round(percentPayment), round(currentAmount));
            report.add(monthReport);

            months--;
        }

        report.setFinalAmount(round(annuityPayment * parameters.getMonthsPeriod()));

        return report;
    }

}
