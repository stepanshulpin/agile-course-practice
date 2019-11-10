package ru.unn.agile.binaryTree.model;

public class Node {
    private  int    _key;
    private  String _value;
    private  Node   _childNode = null;

    public Node(final int key, final String value) {
        _value  = value;
        _key    = key;
    }

    public void addChild(Node childNode) {
        _childNode = childNode;
    }

    public String findRecursive(int key) {
        if (key != _key) {
            return _childNode.findRecursive(key);
        } else {
            return _value;
        }
    }

}
