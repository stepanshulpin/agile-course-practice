package ru.unn.agile.PriorityQueue.model;

public class PriorityQueue<E> {

    private int size = 0;

    public PriorityQueue() {

    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void push(E elem) {
        size++;
    }
}
