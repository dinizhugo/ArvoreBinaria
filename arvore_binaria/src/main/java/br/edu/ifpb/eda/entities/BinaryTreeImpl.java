package br.edu.ifpb.eda.entities;

public class BinaryTreeImpl implements InterfaceBinaryTree {
    private Node root;

    public BinaryTreeImpl() {
        this.root = null;
    }

    @Override
    public void add(int element) {
        if (isEmpty()) {
            this.root = new Node(element);
        } else {
            addRecursive(this.root, element);
        }
    }

    @Override
    public void removeLast() {
        if (this.root == null) { return; }

        root = removeLastRecursive(this.root);
    }

    @Override
    public void removeFirst() {
        if (this.root == null) { return; }
        root = removeFirstRecursive(this.root);
    }


    public Node getRoot() {
        return root;
    }

    private void addRecursive(Node current, int element) {
        if (element < current.getValue()) {
            if (current.getLeft() == null) {
                current.setLeft(new Node(element));
            }else {
                addRecursive(current.getLeft(), element);
            }
        } else {
            if (current.getRight() == null) {
                current.setRight(new Node(element));
            } else  {
                addRecursive(current.getRight(), element);
            }
        }
    }

    private Node removeFirstRecursive(Node node) {
        if (node == null) { return null; }

        if (node.getRight() == null && node.getLeft() == null) { return null; }

        if (node.getLeft() == null) { return node.getRight(); }

        if (node.getRight() == null) { return node.getLeft(); }

        Node successor = findMinValueNode(node.getRight());
        node.setValue(successor.getValue());
        node.setRight(removeMinValueNode(node.getRight()));
        return node;
    }

    private Node findMinValueNode(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private Node removeMinValueNode(Node node) {
        if (node.getLeft() == null) {
            return node.getRight();
        }
        node.setLeft(removeMinValueNode(node.getLeft()));
        return node;
    }

    private Node removeLastRecursive(Node node) {
        if (node == null) { return null; }

        if (node.getRight() == null && node.getLeft() == null) { return null; }

        if (node.getRight() != null) {
            node.setRight(removeLastRecursive(node.getRight()));
            return node;
        }

        if (node.getLeft() != null) {
            node.setLeft(removeLastRecursive(node.getLeft()));
            return node;
        }

        return node;
    }

    private boolean isEmpty() { return getRoot() == null; }

}
