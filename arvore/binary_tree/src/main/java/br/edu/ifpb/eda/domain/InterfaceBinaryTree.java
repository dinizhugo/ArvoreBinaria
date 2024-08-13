package br.edu.ifpb.eda.domain;

public interface InterfaceBinaryTree {
    void add(int value);
    void removeLowestValue();
    void removeHighestValue();
    String toStringPreOrder();
    String toStringInOrder();
    String toStringPostOrder();
}
