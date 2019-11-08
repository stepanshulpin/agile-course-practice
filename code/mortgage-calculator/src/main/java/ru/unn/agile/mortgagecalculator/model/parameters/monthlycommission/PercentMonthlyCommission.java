package ru.unn.agile.mortgagecalculator.model.parameters.monthlycommission;

import ru.unn.agile.mortgagecalculator.model.parameters.Percent;
import ru.unn.agile.mortgagecalculator.model.validation.Validator;

abstract class PercentMonthlyCommission implements MonthlyCommission {

    protected Percent percent;

    public PercentMonthlyCommission(double percent) {
        Validator validator = new Validator();
        validator.checkCorrectPercent(percent);
        this.percent = new Percent(percent);
    }
}
