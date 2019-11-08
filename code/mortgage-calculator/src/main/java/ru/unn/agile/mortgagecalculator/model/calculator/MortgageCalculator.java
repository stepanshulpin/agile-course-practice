package ru.unn.agile.mortgagecalculator.model.calculator;

import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;
import ru.unn.agile.mortgagecalculator.model.report.MortgageReport;

public abstract class MortgageCalculator {

    public abstract MortgageReport calculate(MortgageParameters parameters);

    protected double getCommission(MortgageParameters parameters) {
        if (parameters.getCommission() != null) {
            return parameters.getCommission().calculate(parameters.getAmount());
        } else {
            return 0;
        }
    }

    protected double getMonthlyCommission(MortgageParameters parameters, double currentAmoun) {
        if (parameters.getMonthlyCommission() != null) {
            return parameters.getMonthlyCommission().calculate(parameters, currentAmoun);
        } else {
            return 0;
        }
    }

    double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
