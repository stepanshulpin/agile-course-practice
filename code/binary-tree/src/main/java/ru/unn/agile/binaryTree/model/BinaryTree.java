package ru.unn.agile.binaryTree.model;

public class BinaryTree {
    private double _value;

    public void add(final double value) {
        _value = value;
    }

    public double find(final double value) {
        return _value;
    }
}
