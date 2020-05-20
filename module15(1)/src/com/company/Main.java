package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

//ПП-11
//Терещук Анна
//Варіант 2 (15)
//Задача 1
public class Main {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            Stack st1 = new Stack();
            Stack st2 = new Stack();
            Stack st3 = new Stack();
            System.out.println("Введіть кількість елементів у кожному з трьох стеках: ");
            int N1 = in.nextInt();
            int N2 = in.nextInt();
            int N3 = in.nextInt();
            System.out.println("Введіть значення ваги кожного елем. 1-го стеку: ");
            int total1 = 0;
            int[] values1 = new int[N1];
            for (int i = 0; i < N1; i++) {
                values1[i] = in.nextInt();
            }
            for (int value1 : values1) {
                st1.push(value1);
                total1 += value1;
            }
            System.out.println("Введіть значення ваги кожного елем. 2-го стеку: ");
            int total2 = 0;
            int[] values2 = new int[N2];
            for (int i = 0; i < N2; i++) {
                values2[i] = in.nextInt();
            }
            for (int value2 : values2) {
                st2.push(value2);
                total2 += value2;
            }
            System.out.println("Введіть значення ваги кожного елем. 3-го стеку: ");
            int total3 = 0;
            int[] values3 = new int[N3];
            for (int i = 0; i < N3; i++) {
                values3[i] = in.nextInt();
            }
            for (int value3 : values3) {
                st3.push(value3);
                total3 += value3;
            }
            while (total1 != total2 || total2 != total3) {
                if (total1 < total2) {
                    total2 -= st2.peek();
                    st2.pop();
                }
                if (total1 < total3) {
                    total3 -= st3.peek();
                    st3.pop();
                }
                if (total2 < total1) {
                    total1 -= st1.peek();
                    st1.pop();
                }
                if (total2 < total3) {
                    total3 -= st3.peek();
                    st3.pop();
                }
                if (total3 < total1) {
                    total1 -= st1.peek();
                    st1.pop();
                }
                if (total3 < total2) {
                    total2 -= st2.peek();
                    st2.pop();
                }
            }
            System.out.println("Максимальна спільна вага, при якій стеки дорівнюватимуть одне одному " + total1);
            System.out.println("Виведення елем. 1-го стеку до вирівнювання: ");
            for (int i = N1 - 1; i >= 0; i--) {
                System.out.print(values1[i] + " ");
            }
            System.out.println();
            System.out.println("Виведення елем. 2-го стеку до вирівнювання: ");
            for (int i = N2 - 1; i >= 0; i--) {
                System.out.print(values2[i] + " ");
            }
            System.out.println();
            System.out.println("Виведення елем. 3-го стеку до вирівнювання: ");
            for (int i = N3 - 1; i >= 0; i--) {
                System.out.print(values3[i] + " ");
            }
            System.out.println();
            System.out.println("Виведення елем. 1-го стеку після вирівнювання: ");
            while (!(st1.isEmpty())) {
                System.out.print(st1.pop() + " ");
            }
            System.out.println();
            System.out.println("Виведення елем. 2-го стеку після вирівнювання: ");
            while (!(st2.isEmpty())) {
                System.out.print(st2.pop() + " ");
            }
            System.out.println();
            System.out.println("Виведення елем. 3-го стеку після вирівнювання: ");
            while (!(st3.isEmpty())) {
                System.out.print(st3.pop() + " ");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error!");
        }
    }
}
