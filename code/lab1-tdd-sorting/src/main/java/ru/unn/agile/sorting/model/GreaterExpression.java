package ru.unn.agile.sorting.model;

public class GreaterExpression extends Expression {

    @Override
    public boolean compare(int number1, int number2) {
        if (number1 > number2) {
            return true;
        } else {
            return false;
        }
    }
}
