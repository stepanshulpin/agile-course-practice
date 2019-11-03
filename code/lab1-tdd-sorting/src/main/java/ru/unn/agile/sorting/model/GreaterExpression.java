package ru.unn.agile.sorting.model;

public class GreaterExpression extends Expression {

    @Override
    public boolean compare(final int number1, final int number2) {
        return number1 > number2;
    }
}
