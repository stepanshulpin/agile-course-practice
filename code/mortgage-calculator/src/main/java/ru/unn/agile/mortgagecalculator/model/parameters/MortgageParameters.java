package ru.unn.agile.mortgagecalculator.model.parameters;

import ru.unn.agile.mortgagecalculator.model.parameters.commission.Commission;
import ru.unn.agile.mortgagecalculator.model.parameters.monthlycommission.MonthlyCommission;
import ru.unn.agile.mortgagecalculator.model.validation.Validator;

public class MortgageParameters {

    private static final int MONTHS_IN_YEAR = 12;

    private double amount;
    private Percent percent;
    private int monthsPeriod;
    private double initialPayment;
    private Commission commission;
    private MonthlyCommission monthlyCommission;

    private Validator validator;

    public MortgageParameters(final double amount, final double percent,
                              final PeriodType periodType, final int period) {
        validator = new Validator();
        validate(amount, percent, period);
        this.amount = amount;
        this.percent = new Percent(percent);
        this.monthsPeriod = getMonths(periodType, period);
    }

    public MortgageParameters(final double amount, final double percent, final int period) {
        this(amount, percent, PeriodType.MONTH, period);
    }

    public void setInitialPayment(final double initialPayment) {
        validator.checkPositiveDouble(initialPayment);
        validator.checkCorrectInitialPayment(initialPayment, amount);
        this.initialPayment = initialPayment;
        amount -= initialPayment;
    }

    public double getAmount() {
        return amount;
    }

    public double getFractionPercent() {
        return percent.getValue();
    }

    public double getMonthPercent() {
        return percent.getValue() / MONTHS_IN_YEAR;
    }

    public int getMonthsPeriod() {
        return monthsPeriod;
    }

    public void setCommission(final Commission commission) {
        this.commission = commission;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setMonthlyCommission(final MonthlyCommission monthlyCommission) {
        this.monthlyCommission = monthlyCommission;
    }

    public MonthlyCommission getMonthlyCommission() {
        return monthlyCommission;
    }

    private void validate(final double amount, final double percent, final int period) {
        Validator validator = new Validator();
        validator.checkPositiveDouble(amount);
        validator.checkCorrectPercent(percent);
        validator.checkPositiveInteger(period);
    }

    private int getMonths(final PeriodType periodType, final int period) {
        if (PeriodType.MONTH.equals(periodType)) {
            return period;
        } else {
            return period * MONTHS_IN_YEAR;
        }
    }

}
