package ru.unn.agile.DepositeCalculator.Model;

public class Calculator {

    private final int MAX_PERCENT = 100;

    public double calculate(double startSum, int percent) {
        return startSum + startSum * percent / MAX_PERCENT;
    }
}