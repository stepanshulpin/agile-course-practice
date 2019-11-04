package ru.unn.agile.sorting.api;

public abstract class Sorting<T> {

    private Direction direction;

    private Expression<T> expression;

    public Sorting(final Direction direction, final Expression<T> expression) {
        this.direction = direction;
        this.expression = expression;
    }

    public void setDirection(final Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setExpression(final Expression<T> expression) {
        this.expression = expression;
    }

    public Expression<T> getExpression() {
        return expression;
    }

    public abstract T[] sort(T[] objects);
}
