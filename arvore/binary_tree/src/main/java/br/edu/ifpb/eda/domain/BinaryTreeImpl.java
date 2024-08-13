package br.edu.ifpb.eda.domain;

public class BinaryTreeImpl implements InterfaceBinaryTree {
    private Node root;

    public BinaryTreeImpl() {}

    @Override
    public void add(int value) {
        if (this.root == null) {
            this.root = new Node(value);
        } else {
            addRecursive(this.root, value);
        }
    }


    @Override
    public void removeLowestValue() {
        if (this.root != null) {
            this.root = removeLowestRecursive(this.root);
        }
    }


    @Override
    public void removeHighestValue() {
        if (this.root != null) {
            this.root = removeHighestRecursive(this.root);
        }
    }


    @Override
    public String toStringPreOrder() {
        StringBuilder sb = new StringBuilder();
        toStringPreOrderRecursive(this.root, sb);
        return sb.toString().trim();
    }

    @Override
    public String toStringInOrder() {
        StringBuilder sb = new StringBuilder();
        toStringInOrderRecursive(this.root, sb);
        return sb.toString().trim();
    }

    @Override
    public String toStringPostOrder() {
        StringBuilder sb = new StringBuilder();
        toStringPostOrderRecursive(this.root, sb);
        return sb.toString().trim();
    }

    private void addRecursive(Node currentNode, int value) {
        Node newNode = new Node(value);

        if (value < currentNode.getValue()) {
            if (currentNode.getLeft() == null) {
                currentNode.setLeft(newNode);
            } else {
                addRecursive(currentNode.getLeft(), value);
            }
        } else {
            if (currentNode.getRight() == null) {
                currentNode.setRight(newNode);
            } else {
                addRecursive(currentNode.getRight(), value);
            }
        }
        newNode.setFather(currentNode);
    }

    private Node removeLowestRecursive(Node currentNode) {
        if (currentNode.getLeft() == null) {
            return currentNode.getRight();
        }
        currentNode.setLeft(removeLowestRecursive(currentNode.getLeft()));
        return currentNode;
    }

    private Node removeHighestRecursive(Node currentNode) {
        if (currentNode.getRight() == null) {
            return currentNode.getLeft();
        }

        currentNode.setRight(removeHighestRecursive(currentNode.getRight()));
        return currentNode;
    }

    private void toStringPreOrderRecursive(Node currentNode, StringBuilder sb) {
        if (currentNode != null) {
            sb.append(currentNode.getValue()).append(" ");
            toStringPreOrderRecursive(currentNode.getLeft(), sb);
            toStringPreOrderRecursive(currentNode.getRight(), sb);
        }
    }

    private void toStringInOrderRecursive(Node currentNode, StringBuilder sb) {
        if (currentNode != null) {
            toStringInOrderRecursive(currentNode.getLeft(), sb);
            sb.append(currentNode.getValue()).append(" ");
            toStringInOrderRecursive(currentNode.getRight(), sb);
        }
    }

    private void toStringPostOrderRecursive(Node currentNode, StringBuilder sb) {
        if (currentNode != null) {
            toStringPostOrderRecursive(currentNode.getLeft(), sb);
            toStringPostOrderRecursive(currentNode.getRight(), sb);
            sb.append(currentNode.getValue()).append(" ");
        }
    }

    private Node getRoot() {
        return root;
    }

    private void setRoot(Node root) {
        this.root = root;
    }
}
