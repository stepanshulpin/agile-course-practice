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
        checkForEmptiness();

        int size = list.size();

        return list.remove(size - 1);
    }

    public T peek() {
        checkForEmptiness();

        int size = list.size();

        return list.get(size - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    private void checkForEmptiness() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is Empty!");
        }
    }
}
