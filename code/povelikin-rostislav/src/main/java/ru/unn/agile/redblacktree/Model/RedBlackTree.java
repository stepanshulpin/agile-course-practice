package ru.unn.agile.redblacktree.Model;

public class RedBlackTree {
    // insert
    // get
    // remove

    private int size = 0;

    public RedBlackTree() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int i) {
        ++size;
    }
}
