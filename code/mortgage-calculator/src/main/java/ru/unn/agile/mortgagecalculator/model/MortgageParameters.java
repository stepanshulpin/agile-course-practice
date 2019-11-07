package ru.unn.agile.mortgagecalculator.model;

public class MortgageParameters {

    private final int MONTHS_IN_YEAR = 12;
    private final double FRACTION_OF_HUNDRED = 0.01;

    private double amount;
    private double fractionPercent;
    private int monthsPeriod;

    public MortgageParameters(double amount, double percent, PeriodType periodType, int period) {
        validate(amount, percent, period);
        this.amount = amount;
        this.fractionPercent = convertToFractionPercent(percent);
        this.monthsPeriod = getMonths(periodType, period);
    }

    public MortgageParameters(double amount, double percent, int period) {
        this(amount, percent, PeriodType.MONTH, period);
    }

    public double getAmount() {
        return amount;
    }

    public double getFractionPercent() {
        return fractionPercent;
    }

    public double getMonthPercent() {
        return fractionPercent / MONTHS_IN_YEAR;
    }

    public int getMonthsPeriod() {
        return monthsPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MortgageParameters that = (MortgageParameters) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (Double.compare(that.fractionPercent, fractionPercent) != 0) return false;
        return monthsPeriod == that.monthsPeriod;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fractionPercent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + monthsPeriod;
        return result;
    }

    private void validate(double amount, double percent, int period) {
        Validator validator = new Validator();
        validator.checkPositiveDouble(amount);
        validator.checkCorrectPercent(percent);
        validator.checkPositiveInteger(period);
    }

    private double convertToFractionPercent(double percent) {
        return percent * FRACTION_OF_HUNDRED;
    }

    private int getMonths(PeriodType periodType, int period) {
        if (PeriodType.MONTH.equals(periodType)) {
            return period;
        } else {
            return period * MONTHS_IN_YEAR;
        }
    }

}
