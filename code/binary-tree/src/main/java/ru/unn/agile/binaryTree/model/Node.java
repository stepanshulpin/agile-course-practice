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

    String findRecursive(int key) {
        if (key != _key) {
            return _childNode.findRecursive(key);
        } else {
            return _value;
        }
    }

    int getKey()    { return _key; };
    Node getChild() { return _childNode; }

    boolean removeRecursive(int key) {
        if (_childNode.getKey() == key) {
            _childNode = _childNode.getChild();
            return true;
        } else {
            return removeRecursive(key);
        }
    }

}
