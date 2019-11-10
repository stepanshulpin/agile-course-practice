package ru.unn.agile.PriorityQueue.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PriorityQueue<E extends Comparable<? super E>> {

    private int size = 0;
    private ArrayList<E> arr = new ArrayList<E>();

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
        arr.add(elem);
        arr.sort((a,b) -> b.compareTo(a));
    }

    public E pop() {
        var e = arr.get(0);
        arr.remove(0);
        size--;
        return e;
    }
}
