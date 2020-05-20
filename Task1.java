package com.company;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        DoublyLinkedList myLinkedlist = new DoublyLinkedList();
        System.out.println("Введіть кількість елементів списку=");
        int count=in.nextInt();
        for(int i=0;i<count;i++){
            System.out.println("Введіть елемент для введення");
            myLinkedlist.insertFirst(in.nextInt()); //вставка на початок
        }
        myLinkedlist.insertLast(19); //вставка (в кінець списку) 19
        myLinkedlist.printLinkedListForward(); //виведення в прямому порядку
        myLinkedlist.printLinkedListBackward(); //виведення в оберненому порядку
        myLinkedlist.sorting();
        System.out.println(myLinkedlist);
    }
}
