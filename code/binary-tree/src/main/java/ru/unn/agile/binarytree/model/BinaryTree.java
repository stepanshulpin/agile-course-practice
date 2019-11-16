package ru.unn.agile.binarytree.model;

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
        if (root == null) {
            return null;
        }
        if (root.getKey() == key) {
            return root;
        }
        if (root.getRightChild() == null && root.getLeftChild() == null) {
            return null;
        }
        if (key > root.getKey()) {
            return findNode(root.getRightChild(), key);
        } else {
            return findNode(root.getLeftChild(), key);
        }
    }

    public boolean remove(final int key) {
        if (rootNode == null) {
            return false;
        } else {
            Node temp = findNode(rootNode, key);
            if (temp == null) {
                return false;
            } else {
                rootNode = removeRecursive(rootNode, key);
                return true;
            }
        }
    }

    private Node removeRecursive(final Node root, final int key) {
        if (root == null) {
            return null;
        }
        if (key > root.getKey()) {
            return removeRecursive(root.getRightChild(), key);
        } else if (key < root.getKey()) {
            return removeRecursive(root.getLeftChild(), key);
        }

        if (root.getLeftChild() == null) {
            return root.getRightChild();
        } else if (root.getRightChild() == null) {
            return root.getLeftChild();
        } else {
            Node minNode = rootNode.getMinNode();
            root.set(minNode.getKey(), minNode.getValue());

            removeRecursive(root.getRightChild(), minNode.getKey());
        }
        return root;
    }

    private static void addChild(final Node root, final Node childNode) {
        if (childNode.getKey() > root.getKey()) {
            if (root.getRightChild() != null) {
                addChild(root.getRightChild(), childNode);
            } else {
                root.setRightChild(childNode);
            }
        } else if (childNode.getKey() < root.getKey()) {
            if (root.getLeftChild() != null) {
                addChild(root.getLeftChild(), childNode);
            } else {
                root.setLeftChild(childNode);
            }
        } else {
            root.set(childNode.getKey(), childNode.getValue());
        }
    }

    private Node getRoot() {
        return rootNode;
    }

    public int getHeight() {
        return rootNode.getHeight();
    }
}
