package ru.unn.agile.mortgagecalculator.model.calculator;

import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;
import ru.unn.agile.mortgagecalculator.model.report.MortgageReport;

public class MortgageWithAnnuityPaymentsCalculator extends MortgageCalculator {

    @Override
    public MortgageReport calculate(MortgageParameters parameters) {
        int months = parameters.getMonthsPeriod();
        double monthPercent = parameters.getMonthPercent();
        double annuityPayment = parameters.getAmount() * (monthPercent + monthPercent / (Math.pow(1 + monthPercent, months) - 1));

        MortgageReport report = new MortgageReport(parameters.getAmount());

        report.setFinalAmount(round(annuityPayment * months));

        return report;
    }

}
