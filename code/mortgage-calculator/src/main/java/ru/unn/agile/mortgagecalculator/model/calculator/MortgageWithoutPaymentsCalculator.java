package ru.unn.agile.mortgagecalculator.model.calculator;

import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;
import ru.unn.agile.mortgagecalculator.model.report.MortgageReport;

public class MortgageWithoutPaymentsCalculator extends MortgageCalculator {

    @Override
    public MortgageReport calculate(MortgageParameters parameters) {
        int months = parameters.getMonthsPeriod();
        double monthPercent = parameters.getMonthPercent();
        double percent = parameters.getFractionPercent();
        double finalAmount = parameters.getAmount();
        while (months >= 12) {
            finalAmount = finalAmount + round(finalAmount * percent);
            months -= 12;
        }

        MortgageReport report = new MortgageReport(parameters.getAmount());

        finalAmount = finalAmount + round(finalAmount * monthPercent * months);

        report.setFinalAmount(finalAmount);

        return report;
    }

}
