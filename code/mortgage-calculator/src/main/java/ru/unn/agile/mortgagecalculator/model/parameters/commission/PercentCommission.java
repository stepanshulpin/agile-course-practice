package ru.unn.agile.mortgagecalculator.model.parameters.commission;

import ru.unn.agile.mortgagecalculator.model.parameters.Percent;
import ru.unn.agile.mortgagecalculator.model.validation.Validator;

public class PercentCommission implements Commission {

    private Percent percent;

    public PercentCommission(double percent) {
        Validator validator = new Validator();
        validator.checkCorrectPercent(percent);
        this.percent = new Percent(percent);
    }

    @Override
    public double calculate(double amount) {
        return percent.getPercent() * amount;
    }
}