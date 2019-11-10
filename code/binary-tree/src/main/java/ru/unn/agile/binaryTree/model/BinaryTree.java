package ru.unn.agile.binaryTree.model;

public class BinaryTree {
    private Node rootNode = null;

    public void add(final int key, final String value) {
        if (rootNode == null) {
            rootNode = new Node(key, value);
        } else {
            addChild(rootNode, new Node(key, value));
        }
    }

    public String find(final int key) {
        if (rootNode == null) {
            return null;
        } else {
            return rootNode.findRecursive(key);
        }
    }

    public boolean remove(final int key) {
        if (rootNode == null) {
            return false;
        } else {
                if (rootNode.getKey() == key) {
                rootNode = rootNode.getChild();
                return true;
            } else {
                return removeRecursive(rootNode, key);
            }
        }
    }

    private boolean removeRecursive(final Node root, final int key) {
        if (root.getChild() == null) {
            return false;
        }
        if (root.getChild().getKey() == key) {
            root.setChild(root.getChild().getChild());
            return true;
        } else {
            return removeRecursive(root.getChild(), key);
        }
    }

    static void addChild(final Node root, final Node childNode) {
        if (root.getChild() != null) {
            addChild(root.getChild(), childNode);
        } else {
            root.setChild(childNode);
        }
    }

    Node getRoot() {
        return rootNode;
    }

    public int getHeight() {
        return rootNode.getHeight();
    }
}
