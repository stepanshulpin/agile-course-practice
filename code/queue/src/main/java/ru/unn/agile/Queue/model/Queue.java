package ru.unn.agile.Queue.model;
import java.util.LinkedList;

public class Queue<Type> {

    private LinkedList<Type> list;

    public Queue() {
        list = new LinkedList<Type>();
    }

    public void push(final Type element) {
        if (element == null) {
            throw new IllegalArgumentException("The item cannot be empty.");
        }

        list.add(element);
    }

    public Type getTail() {
        checkIsNotEmpty();

        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    private void checkIsNotEmpty() {
        if (isEmpty()) {
            throw new NullPointerException("Queue is empty");
        }
    }
}
