package br.edu.ifpb.eda;

import br.edu.ifpb.eda.domain.BinaryTreeImpl;
import br.edu.ifpb.eda.domain.InterfaceBinaryTree;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        InterfaceBinaryTree minhaLista = new BinaryTreeImpl();
        Random random = new Random();

        for (int i = 1; i < 10; i++) {
            int number = random.nextInt(0, 50);
            minhaLista.add(number);
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.println("========");

        System.out.println("Pre Order:");
        System.out.println(minhaLista.toStringPreOrder());
        System.out.println("=============");
        System.out.println("In Order:");
        System.out.println(minhaLista.toStringInOrder());
        System.out.println("=============");
        System.out.println("Post Order:");
        System.out.println(minhaLista.toStringPostOrder());
        System.out.println("=============");

    }
}