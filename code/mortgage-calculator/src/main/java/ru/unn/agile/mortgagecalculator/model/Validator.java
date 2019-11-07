package ru.unn.agile.mortgagecalculator.model;

class Validator {

    void checkPositiveInteger(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("A positive integer is expected");
        }
    }

}
