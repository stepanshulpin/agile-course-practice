package ru.unn.agile.sorting.model;

public final class Sorting {

    private Direction direction;

    private Expression expression;

    public Sorting() {
        direction = Direction.ASC;
        this.expression = new LessExpression();
    }

    public Sorting(final Direction direction) {
        this.direction = direction;
        this.expression = new LessExpression();
    }

    public Sorting(final Expression expression) {
        direction = Direction.ASC;
        this.expression = expression;
    }

    public Sorting(final Direction direction, final Expression expression) {
        this.direction = direction;
        this.expression = expression;
    }

    public void setDirection(final Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setExpression(final Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public int[] sort(final int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int current = numbers[i];
            int j = i - 1;
            while (j >= 0 && compareTwoNumber(current, numbers[j])) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = current;
        }
        return numbers;
    }

    private boolean compareTwoNumber(final int number1, final int number2) {
        if (direction.equals(Direction.ASC)) {
            return expression.compare(number1, number2);
        } else {
            return !expression.compare(number1, number2);
        }
    }
}
