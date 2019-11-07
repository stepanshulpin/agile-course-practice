package ru.unn.agile.mortgagecalculator.model.calculator;

import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;
import ru.unn.agile.mortgagecalculator.model.report.MortgageReport;

public abstract class MortgageCalculator {

    public abstract MortgageReport calculate(MortgageParameters parameters);

    double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
