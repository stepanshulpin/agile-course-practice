package ru.unn.agile.DepositeCalculator.Model;

public class Calculator {

    private final int MAX_PERCENT = 100;
    private final int MONTH_IN_YEAR = 12;

    public double calculate(double startSum, int percent, int months) {
        return startSum + startSum * months / MONTH_IN_YEAR * percent / MAX_PERCENT;
    }
}