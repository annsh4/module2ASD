package me.uquark.univ.ads.module;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Tree<Integer> tree = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Количество нод: ");
        int n = scanner.nextInt();
        if (n <= 0)
            return;
        System.out.println("Ноды: ");
        for (int i=0; i < n; i++) {
            int value = scanner.nextInt();
            if (tree == null)
                tree = new Tree<>(value, null);
            else
                tree.add(value);
        }
        System.out.println("Дерево:");
        tree.forEachNode(node -> {
            if (node == null)
                System.out.print("n");
            else
                System.out.print(node.value);
            System.out.print(" ");
        });
        System.out.println();

        System.out.print("Нода 1: ");
        int nodeValue1 = scanner.nextInt();
        System.out.print("Нода 2: ");
        int nodeValue2 = scanner.nextInt();
        Tree<Integer> node1 = tree.find(value -> value == nodeValue1);
        Tree<Integer> node2 = tree.find(value -> value == nodeValue2);
        Tree<?> lca = Tree.lca(node1, node2);
        if (lca == null)
            System.out.println("Либо это два разных дерева, либо алгоритм не работает");
        else
            System.out.printf("Наименьший общий предок: %d\n", lca.value);
    }
}
