package ru.unn.agile.binaryTree.model;

class Node {
    private  int    key;
    private  String value;

    private  Node   rightChild;
    private  Node   leftChild;

    Node(final int key, final String value) {
        this.value = value;
        this.key = key;

        this.rightChild = null;
        this.leftChild  = null;
    }

    public void setChild(final Node childNode) {
        this.rightChild = childNode;
    }

    int getKey() {
        return key;
    };

    String getValue() {
        return value;
    }

    Node getRightChild() {
        return rightChild;
    }

    int getHeight() {
        if (rightChild == null) {
            return 1;
        } else {
            return rightChild.getHeight() + 1;
        }
    }
}
