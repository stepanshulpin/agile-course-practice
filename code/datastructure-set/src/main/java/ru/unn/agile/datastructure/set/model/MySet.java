package ru.unn.agile.datastructure.set.model;

import java.util.ArrayList;
import java.util.List;

public class MySet<E> {

    private List<E> container;

    public MySet() {
        container = new ArrayList<>();
    }

    public int size() {
        return this.container.size();
    }

    public boolean add(final E e) {
        if (e == null) {
            throw new NullPointerException("MySet collection doesn't support Null values");
        }

        if (!this.container.contains(e)) {
            return this.container.add(e);
        }

        return false;
    }

    public boolean isEmpty() {
        return this.container.isEmpty();
    }

    public void clear() {
        this.container.clear();
    }

    public Object[] toArray() {
        return this.container.toArray();
    }

    public boolean contains(final E e) {
        return this.container.contains(e);
    }

    public boolean remove(final E e) {
        return this.container.remove(e);
    }
}
