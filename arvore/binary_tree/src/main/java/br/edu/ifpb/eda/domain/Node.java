package br.edu.ifpb.eda.domain;

public class Node {
    private int value;
    private Node left;
    private Node right;
    private Node father;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.father = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }
}
