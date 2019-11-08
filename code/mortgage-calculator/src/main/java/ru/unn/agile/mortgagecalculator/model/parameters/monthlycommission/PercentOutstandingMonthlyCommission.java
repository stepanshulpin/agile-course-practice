package ru.unn.agile.mortgagecalculator.model.parameters.monthlycommission;

import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;

public class PercentOutstandingMonthlyCommission extends PercentMonthlyCommission {

    public PercentOutstandingMonthlyCommission(double percent) {
        super(percent);
    }

    @Override
    public double calculate(MortgageParameters parameters, double currentAmount) {
        return currentAmount * percent.getPercent();
    }
}
