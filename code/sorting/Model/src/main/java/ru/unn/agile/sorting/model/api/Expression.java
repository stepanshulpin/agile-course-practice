package ru.unn.agile.sorting.model.api;

public abstract class Expression<T> {
    public abstract boolean compare(T object1, T object2);
}
