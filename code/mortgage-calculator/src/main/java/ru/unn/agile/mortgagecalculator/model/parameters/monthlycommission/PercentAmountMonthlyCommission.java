package ru.unn.agile.mortgagecalculator.model.parameters.monthlycommission;

import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;

public class PercentAmountMonthlyCommission extends PercentMonthlyCommission {

    public PercentAmountMonthlyCommission(double percent) {
        super(percent);
    }

    @Override
    public double calculate(MortgageParameters parameters, double currentAmount) {
        return parameters.getAmount() * percent.getPercent();
    }
}
