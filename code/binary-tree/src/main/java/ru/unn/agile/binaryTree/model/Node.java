package ru.unn.agile.binaryTree.model;

public class Node {
    private  double _value;
    private  Node   _childNode = null;

    public Node(double value) {
        _value = value;
    }

    public void addChild(Node childNode) {
        _childNode = childNode;
    }

    public double findRecursive(double value) {
        if (value != _value) {
            return _childNode.findRecursive(value);
        } else {
            return _value;
        }
    }

}
