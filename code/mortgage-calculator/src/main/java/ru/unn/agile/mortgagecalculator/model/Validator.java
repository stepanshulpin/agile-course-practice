package ru.unn.agile.mortgagecalculator.model;

public class Validator {

    public void checkPositiveInteger(int value) {
        if(value <= 0) {
            throw new IllegalArgumentException("A positive integer is expected");
        }
    }

}
