package com.company;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try {
            BinarySearchTree<Integer> searchTree = null;
            Scanner in = new Scanner(System.in);
            System.out.print("Number of nodes: ");
            int a = in.nextInt();
            if (a <= 0)
                return;
            System.out.println("Nodes:");
            for (int i=0; i < a; i++) {
                int value = in.nextInt();
                if (searchTree == null)
                    searchTree = new BinarySearchTree<>(value, null);
                else
                    searchTree.add(value);
            }
            System.out.println("BinarySearchTree:");
            searchTree.forEachNode(node -> {
                if (node == null)
                    System.out.print("?");
                else
                    System.out.print(node.value);
                System.out.print(" ");
            });
            System.out.println();

            System.out.print("Enter n1: ");
            int nodeValue1 = in.nextInt();
            System.out.print("Enter n2: ");
            int nodeValue2 = in.nextInt();
            BinarySearchTree<Integer> n1 = searchTree.find(value -> value == nodeValue1);
            BinarySearchTree<Integer> n2 = searchTree.find(value -> value == nodeValue2);
            BinarySearchTree<?> LCA = BinarySearchTree.LCA(n1, n2);
            if (LCA == null)
                System.out.println("Two different trees");
            else
                System.out.printf("LCA: %d\n", LCA.value);
        } catch (InputMismatchException e) {
            System.out.println("Error");
        } catch (Exception e) {
            System.out.println("Sorry! Error");
            e.printStackTrace();
        }
    }
}