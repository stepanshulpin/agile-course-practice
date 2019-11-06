package ru.unn.agile.datastructure.set.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MySet<E> {

    private static final String ERROR_MESSAGE = "MySet collection doesn't support Null values";
    private List<E> container;

    public MySet() {
        container = new ArrayList<>();
    }

    public int size() {
        return this.container.size();
    }

    public boolean add(final E e) {
        if (e == null) {
            throw new NullPointerException(ERROR_MESSAGE);
        }

        if (!this.container.contains(e)) {
            return this.container.add(e);
        }

        return false;
    }

    public boolean addAll(final Collection<E> e) {
        boolean modified = false;
        for (E elem : e) {
            if (this.add(elem)) {
                modified = true;
            }
        }

        return modified;
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
        if (e == null) {
            throw new NullPointerException(ERROR_MESSAGE);
        }

        return this.container.contains(e);
    }

    public boolean remove(final E e) {
        if (e == null) {
            throw new NullPointerException(ERROR_MESSAGE);
        }

        return this.container.remove(e);
    }

    public Iterator<E> iterator() {
        return this.container.iterator();
    }

    public boolean containsAll(final Collection<E> e) {
        return this.container.containsAll(e);
    }

    public boolean removeAll(final Collection<E> e) {
        return this.container.removeAll(e);
    }

    public boolean retainAll(final Collection<E> e) {
        return this.container.retainAll(e);
    }
}
