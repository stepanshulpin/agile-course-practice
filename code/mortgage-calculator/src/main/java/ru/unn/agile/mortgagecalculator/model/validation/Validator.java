package ru.unn.agile.mortgagecalculator.model.validation;

public class Validator {

    private static final double PERCENT_MIN = 0.01;
    private static final double PERCENT_MAX = 60;

    public void checkPositiveInteger(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("A positive integer is expected");
        }
    }

    public void checkPositiveDouble(final double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("A positive double is expected");
        }
    }

    public void checkCorrectPercent(final double percent) {
        if (percent < PERCENT_MIN || percent > PERCENT_MAX) {
            throw new IllegalArgumentException("Percent from 0.01 to 60 is expected");
        }
    }

    public void checkReportSize(final int month, final int size) {
        if (month < 1 || month > size) {
            throw new IllegalArgumentException("Month from 1 to " + size + " is expected ");
        }
    }

    public void checkCorrectInitialPayment(final double initialPayment, final double amount) {
        if (initialPayment >= amount) {
            throw new IllegalArgumentException("The payment cannot be more than the total amount");
        }
    }
}
