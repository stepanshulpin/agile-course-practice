package ru.unn.agile.binaryTree.model;

public class BinaryTree {
    private Node rootNode = null;

    public void add(final double value) {
        if (rootNode == null) {
            rootNode = new Node(value);
        } else {
            rootNode.addChild(new Node(value));
        }
    }

    public double find(final double value) {
        return rootNode.findRecursive(value);
    }
}
