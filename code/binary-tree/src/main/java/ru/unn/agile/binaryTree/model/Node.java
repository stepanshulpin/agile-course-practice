package ru.unn.agile.binaryTree.model;

class Node {
    private  int    key;
    private  String value;
    private  Node   childNode = null;

    Node(final int key, final String value) {
        this.value = value;
        this.key = key;
    }

    public void setChild(final Node childNode) {
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

    String getValue() {
        return value;
    }

    Node getChild() {
        return childNode;
    }

    int getHeight() {
        if (childNode == null) {
            return 1;
        } else {
            return childNode.getHeight() + 1;
        }
    }
}
