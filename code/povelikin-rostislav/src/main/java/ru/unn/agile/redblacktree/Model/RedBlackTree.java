package ru.unn.agile.redblacktree.Model;

public class RedBlackTree {
    private class Node {
        int key, color = BLACK;
        Node left = nil, right = nil, parent = nil;

        Node(int key) {
            this.key = key;
        }
    }

    private final int RED = 0;
    private final int BLACK = 1;
    private final Node nil = new Node(-1);

    private Node root = nil;
    private int size = 0;

    public RedBlackTree() {}

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public boolean remove(int value) {
        Node z = getNode(value);

        if (z != nil) {
            --size;
        } else {
            return false;
        }

        Node x;
        Node y = z; // temporary reference y

        int y_original_color = y.color;

        if (z.left == nil) {
            x = z.right;
            transplant(z, z.right);
        } else if(z.right == nil) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = treeMinimum(z.right);
            y_original_color = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            }
            else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            transplant(z, y);

            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }

        if(y_original_color==BLACK) {
            deleteFix(x);
        }

        return true;
    }

    public boolean find(int expected) {
        if (root == nil) {
            return false;
        }

        Node temp = root;

        while (true) {
            if (expected == temp.key) {
                return true;
            } else if (expected < temp.key) {
                if (temp.left == nil) {
                    return false;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == nil) {
                    return false;
                } else {
                    temp = temp.right;
                }
            }
        }
    }

    private Node getNode(int expected) {
        if (root == nil) {
            return nil;
        }

        Node temp = root;

        while (true) {
            if (expected == temp.key) {
                return temp;
            } else if (expected < temp.key) {
                if (temp.left == nil) {
                    return nil;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == nil) {
                    return nil;
                } else {
                    temp = temp.right;
                }
            }
        }
    }

    public void insert(int value) {
        ++size;
        var node = new Node(value);

        Node temp = root;

        if (root == nil) {
            root = node;
            node.color = BLACK;
            node.parent = nil;
        } else {
            node.color = RED;
            while (true) {
                if (node.key < temp.key) {
                    if (temp.left == nil) {
                        temp.left = node;
                        node.parent = temp;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else {
                    if (temp.right == nil) {
                        temp.right = node;
                        node.parent = temp;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
            fixTree(node);
        }
    }

    private void fixTree(Node node) {
        while (node.parent.color == RED) {
            Node uncle;
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;

                if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.right) {
                    //Double rotation needed
                    node = node.parent;
                    rotateLeft(node);
                }
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation
                rotateRight(node.parent.parent);
            } else {
                uncle = node.parent.parent.left;
                if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.left) {
                    //Double rotation needed
                    node = node.parent;
                    rotateRight(node);
                }
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation
                rotateLeft(node.parent.parent);
            }
        }
        root.color = BLACK;
    }

    private void rotateLeft(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            node.right.parent = node.parent;
            node.parent = node.right;
            if (node.right.left != nil) {
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left = node;
        } else {//Need to rotate root
            Node right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = nil;
            root = right;
        }
    }

    private void rotateRight(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }

            node.left.parent = node.parent;
            node.parent = node.left;
            if (node.left.right != nil) {
                node.left.right.parent = node;
            }
            node.left = node.left.right;
            node.parent.right = node;
        } else {//Need to rotate root
            Node left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = nil;
            root = left;
        }
    }

    private void transplant(Node target, Node with){
        if(target.parent == nil){
            root = with;
        }else if(target == target.parent.left){
            target.parent.left = with;
        }else
            target.parent.right = with;
        with.parent = target.parent;
    }

    private void deleteFix(Node x){
        while(x!=root && x.color == BLACK){
            if(x == x.parent.left){
                Node w = x.parent.right;
                if(w.color == RED){
                    w.color = BLACK;
                    x.parent.color = RED;
                    rotateLeft(x.parent);
                    w = x.parent.right;
                }
                if(w.left.color == BLACK && w.right.color == BLACK){
                    w.color = RED;
                    x = x.parent;
                    continue;
                }
                else if(w.right.color == BLACK){
                    w.left.color = BLACK;
                    w.color = RED;
                    rotateRight(w);
                    w = x.parent.right;
                }
                if(w.right.color == RED){
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.right.color = BLACK;
                    rotateLeft(x.parent);
                    x = root;
                }
            }else{
                Node w = x.parent.left;
                if(w.color == RED){
                    w.color = BLACK;
                    x.parent.color = RED;
                    rotateRight(x.parent);
                    w = x.parent.left;
                }
                if(w.right.color == BLACK && w.left.color == BLACK){
                    w.color = RED;
                    x = x.parent;
                    continue;
                }
                else if(w.left.color == BLACK){
                    w.right.color = BLACK;
                    w.color = RED;
                    rotateLeft(w);
                    w = x.parent.left;
                }
                if(w.left.color == RED){
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.left.color = BLACK;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
        x.color = BLACK;
    }

    private Node treeMinimum(Node subTreeRoot){
        while(subTreeRoot.left != nil) {
            subTreeRoot = subTreeRoot.left;
        }
        return subTreeRoot;
    }
}
