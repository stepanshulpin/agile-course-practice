package ru.unn.agile.Queue.model;
import java.util.LinkedList;

public class Queue<Type> {

    private LinkedList<Type> list;

    public Queue() {
        list = new LinkedList<Type>();
    }
}
