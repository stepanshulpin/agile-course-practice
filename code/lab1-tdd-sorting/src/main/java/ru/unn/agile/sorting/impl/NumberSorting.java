package ru.unn.agile.sorting.impl;

import ru.unn.agile.sorting.api.*;

public final class NumberSorting extends Sorting<Integer> {

    public NumberSorting() {
        super(Direction.ASC, new NumberLessExpression());
    }

    public NumberSorting(final Direction direction) {
        super(direction, new NumberLessExpression());
    }

    public NumberSorting(final Expression<Integer> expression) {
        super(Direction.ASC, expression);
    }

    public NumberSorting(final Direction direction, final Expression<Integer> expression) {
        super(direction, expression);
    }

    @Override
    public Integer[] sort(final Integer[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int current = numbers[i];
            int j = i - 1;
            while (j >= 0 && compareTwoNumbers(current, numbers[j])) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = current;
        }
        return numbers;
    }

    private boolean compareTwoNumbers(final int number1, final int number2) {
        if (getDirection().equals(Direction.ASC)) {
            return getExpression().compare(number1, number2);
        } else {
            return !getExpression().compare(number1, number2);
        }
    }
}
