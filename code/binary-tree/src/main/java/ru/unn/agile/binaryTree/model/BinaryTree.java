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
            Node foundNode = findNode(rootNode, key);
            if (foundNode == null) {
                return null;
            } else {
                return foundNode.getValue();
            }
        }
    }

    private static Node findNode(final Node root, final int key) {
        if (root.getKey() == key) {
            return root;
        }
        if (root.getRightChild() != null) {
            return findNode(root.getRightChild(), key);
        } else {
            return null;
        }
    }

    public boolean remove(final int key) {
        if (rootNode == null) {
            return false;
        } else {
                if (rootNode.getKey() == key) {
                rootNode = rootNode.getRightChild();
                return true;
            } else {
                return removeRecursive(rootNode, key);
            }
        }
    }

    private boolean removeRecursive(final Node root, final int key) {
        if (root.getRightChild() == null) {
            return false;
        }
        if (root.getRightChild().getKey() == key) {
            root.setChild(root.getRightChild().getRightChild());
            return true;
        } else {
            return removeRecursive(root.getRightChild(), key);
        }
    }

    static void addChild(final Node root, final Node childNode) {
        if (root.getRightChild() != null) {
            addChild(root.getRightChild(), childNode);
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
