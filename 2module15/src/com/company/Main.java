package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

//ПП-11
//Терещук Анна
//Варіант 2 (15)
//Задача 2
public class Main {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            DoublyLinkedList dll = new DoublyLinkedList();
            System.out.print("Введіть кількість значечь N, що будуть прийняті у список: ");
            int N = in.nextInt();
            System.out.println("Введіть необхідні значення: ");
            int[] values = new int[N];
            for (int i = 0; i < N; i++) {
                values[i] = in.nextInt();
            }
            for (int value : values) {
                dll.addNode(value);
            }
            dll.display();
            System.out.print("\nВведіть кількість значечь Add, що будуть додані до списку: ");
            int Add = in.nextInt();
            System.out.println("Введіть необхідні значення: ");
            int[] addValues = new int[Add];
            for (int i = 0; i < Add; i++) {
                addValues[i] = in.nextInt();
            }
            for (int addValue : addValues) {
                dll.addNode(addValue);
            }
            dll.sortList();
            dll.display();
        } catch (InputMismatchException e) {
            System.out.println("Error!");
        }
    }
}
