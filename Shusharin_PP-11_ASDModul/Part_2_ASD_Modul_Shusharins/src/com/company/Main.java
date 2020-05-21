package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    // Модуль 2, Шушарина Андрея (ПП-11), Задание №2

//    Створити стек цілочисельних значень. На початку програма
//    зчитує три значення (N1, N2, N3 кількість елементів в стеку). В наступних трьох
//    рядках вводимо значення ваги кожного елемента стеку.
//    Програма повинна визначити чи можна отримати рівне значення в усіх
//    трьох стеках видаляючі зайві елементи.
//    Результатом роботи має бути виведення максимальної спільної ваги при
//    якій стеки будуть дорівнювати одне одному та самі стеки до та після
//    вирівнювання.

    static LinkedList<Integer> myList = new LinkedList<>();

    public static void main(String[] args) {

        System.out.print("Введите кол-во елементов: ");
        int n = getInt();

        System.out.print("Введите кол-во елементов которые собираетесь добавить: ");
        int add = getInt();

        for (int i = 0; i < n; i++)
        {
            System.out.print("Введите первоначальный элемент: ");
            int toList = getInt();
            myList.addLast(toList);
        }

        System.out.println("Ваш массив: ");
        for (int i = 0; i < n; i++)
        {
            System.out.println(myList.get(i));
        }

        for (int i = 0; i < add; i++)
        {
            System.out.print("Введите дополнительный элемент: ");
            int toList = getInt();
            myList.addLast(toList);
        }

        selectionSort();

        System.out.println("Ваш массив: ");

        for (int i = 0; i < (add + n); i++)
        {
            System.out.println(myList.get(i));
        }
    }

    protected static void selectionSort()
    {
        int length = myList.size();
        for (int i = 0; i < length-1; i++)
        {
            int min = i;
            for (int j = i+1; j < length; j++)
            {
                if (myList.get(j) < myList.get(min))
                    min = j;
            }

            int temp =  myList.get(min);
            myList.set(min, myList.get(i));
            myList.set(i, temp);
        }
    }

    private static int getInt(){
        while(true)
        {
            int a;
            Scanner num = new Scanner(System.in);
            if (num.hasNextInt())
            {
                a = num.nextInt();
                return a;
            }
            else {
                System.out.print("Введённые вами данные не верны, пожалуйста повторите попытку: ");
            }
        }
    }
}
