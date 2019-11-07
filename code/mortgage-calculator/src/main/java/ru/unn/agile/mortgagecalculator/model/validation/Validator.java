package ru.unn.agile.mortgagecalculator.model.validation;

public class Validator {

    public void checkPositiveInteger(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("A positive integer is expected");
        }
    }

    public void checkPositiveDouble(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("A positive double is expected");
        }
    }

    public void checkCorrectPercent(double percent) {
        if (percent < 0.01 || percent > 60) {
            throw new IllegalArgumentException("Percent from 0.01 to 60 is expected");
        }
    }

    public void checkReportSize(int month, int size) {
        if (month < 1 || month > size) {
            throw new IllegalArgumentException("Month from 1 to " + size + " is expected ");
        }
    }

}
