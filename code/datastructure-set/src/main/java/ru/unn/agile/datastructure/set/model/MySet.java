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

    public Boolean add(final E e) {
        return this.container.add(e);
    }

    public Boolean isEmpty() {
        return this.container.isEmpty();
    }

    public void clear() {
        this.container.clear();
    }
}
