package ru.unn.agile.binaryTree.model;

public class BinaryTree {
    private Node rootNode = null;

    public void add(final int key, final String value) {
        if (rootNode == null) {
            rootNode = new Node(key, value);
        } else {
            rootNode.addChild(new Node(key, value));
        }
    }

    public String find(final int key) {
        return rootNode.findRecursive(key);
    }
}
