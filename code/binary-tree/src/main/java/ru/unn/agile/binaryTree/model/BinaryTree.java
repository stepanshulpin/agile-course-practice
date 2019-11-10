package ru.unn.agile.binaryTree.model;

public class BinaryTree {
    private double _value;

    public void addElement(final double value) {
        _value = value;
    }

    public double getElement() {
        return _value;
    }
}
