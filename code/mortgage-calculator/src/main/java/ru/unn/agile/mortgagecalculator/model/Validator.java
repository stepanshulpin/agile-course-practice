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
        if (percent < 1 || percent > 100) {
            throw new IllegalArgumentException("Percent from 1 to 100 is expected");
        }
    }

}
