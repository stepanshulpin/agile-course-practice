package ru.unn.agile.DepositeCalculator.Model;

public class Calculator {

    private final int MAX_PERCENT = 100;

    public double calculate(double startSum, int percent, int years) {
        return startSum + startSum * years *percent / MAX_PERCENT;
    }
}