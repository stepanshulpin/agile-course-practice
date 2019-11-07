package ru.unn.agile.stack.model;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private List<T> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public boolean isStackCreated() {
        return list != null;
    }

    public void push(final T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item can't be null!");
        }
        list.add(item);
    }

    public T pop() {
        int size = list.size();

        if (size < 1) {
            throw new IndexOutOfBoundsException("Stack is empty!");
        }

        return list.remove(size - 1);
    }

    public T peek() {
        int size = list.size();

        if (size < 1) {
            throw new IndexOutOfBoundsException("Stack is Empty!");
        }

        return list.get(size - 1);
    }
}
