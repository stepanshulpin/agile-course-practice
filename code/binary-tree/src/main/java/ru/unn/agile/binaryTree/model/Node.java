package ru.unn.agile.binaryTree.model;

public class Node {
    private  int    key;
    private  String value;
    private  Node   childNode = null;

    public Node(final int key, final String value) {
        this.value = value;
        this.key = key;
    }

    public void addChild(final Node childNode) {
        this.childNode = childNode;
    }

    String findRecursive(final int key) {
        if (key != this.key) {
            if (childNode != null) {
                return childNode.findRecursive(key);
            } else {
                return null;
            }
        } else {
            return value;
        }
    }

    int getKey() {
        return key;
    };
    Node getChild() {
        return childNode;
    }

    boolean removeRecursive(final int key) {
        if (childNode == null) {
            return false;
        }
        if (childNode.getKey() == key) {
            childNode = childNode.getChild();
            return true;
        } else {
            return removeRecursive(key);
        }
    }

}
