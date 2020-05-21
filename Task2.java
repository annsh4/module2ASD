package com.company;

import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        BinaryTree binaryTree=new BinaryTree();
        System.out.println("Введіть кількість вузлів= ");
        int nodes=in.nextInt();
        for(int i=0;i<nodes;i++){
            System.out.println("Введіть елемент для добавлення");
            binaryTree.insert(in.nextInt(),in.nextLine()); //вставляємо введений з клавіат. елем.
        }
        Nodes find1=binaryTree.find(1);
        binaryTree.print(find1);
    }
}
