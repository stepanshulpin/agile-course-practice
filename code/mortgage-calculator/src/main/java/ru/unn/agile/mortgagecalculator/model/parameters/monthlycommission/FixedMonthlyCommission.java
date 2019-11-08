package ru.unn.agile.mortgagecalculator.model.parameters.monthlycommission;

import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;
import ru.unn.agile.mortgagecalculator.model.validation.Validator;

public class FixedMonthlyCommission implements MonthlyCommission {

    private double value;

    public FixedMonthlyCommission(double value) {
        Validator validator = new Validator();
        validator.checkPositiveDouble(value);
        this.value = value;
    }

    @Override
    public double calculate(MortgageParameters parameters, double currentAmount) {
        return value;
    }
}
