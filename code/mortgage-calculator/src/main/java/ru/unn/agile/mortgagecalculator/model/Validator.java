package ru.unn.agile.mortgagecalculator.model;

class Validator {

    void checkPositiveInteger(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("A positive integer is expected");
        }
    }

    void checkPositiveDouble(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("A positive double is expected");
        }
    }

    void checkCorrectPercent(double percent) {
        if (percent < 0.01 || percent > 60) {
            throw new IllegalArgumentException("Percent from 0.01 to 60 is expected");
        }
    }

    void checkReportSize(int month, int size) {
        if (month < 1 || month > size) {
            throw new IllegalArgumentException("Month from 1 to " + size + " is expected ");
        }
    }

}
