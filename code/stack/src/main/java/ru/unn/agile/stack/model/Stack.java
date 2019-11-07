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
}
