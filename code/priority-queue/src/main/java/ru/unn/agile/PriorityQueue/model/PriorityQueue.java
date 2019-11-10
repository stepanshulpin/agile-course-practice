package ru.unn.agile.PriorityQueue.model;

import java.util.ArrayList;

public class PriorityQueue<E> {

    private int size = 0;
    private ArrayList<E> arr;

    public PriorityQueue() {
        this.arr = new ArrayList<E>();
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void push(E elem) {
        size++;
        arr.add(elem);
    }

    public E pop() {
        var e = arr.get(0);
        size--;
        return e;
    }
}
