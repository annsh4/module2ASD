package com.company;
import java.util.Scanner;

public class Main {

    // Модуль 2, Шушарина Андрея (ПП-11), Задание №1

    //Створити стек цілочисельних значень. На початку роботи
    //програма приймає в себе N-кількість операцій над стеком. Операції
    //позначаються «1» - додавання числа в стек (у вигляді: 1 27), «2» - видалення
    //числа зі стеку, «3» виведення найбільшого значення стеку на момент запиту.
    //Результатом роботи має бути виведення остаточного варіанту стеку після
    //N-операцій та усіх найбільших значень у стеку на момент їх запиту.

    protected static boolean question = true;
    protected static int menu;

    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        MyStack myStack = new MyStack();

        System.out.print("Введите номер операции и элемент как указано в задании: ");

        int numberOfOperation = num.nextInt();
        int element = num.nextInt();

        myStack.firstCheck(numberOfOperation);
        myStack.addToStack(element);
        do {
            System.out.print("Ваша следующая операция, а также число (даже если для выполнения" +
                    " операции оно не понадобится): ");
            numberOfOperation = num.nextInt();
            element = num.nextInt();

            switch (numberOfOperation)
            {
                case 1:
                    myStack.addToStack(element);
                    break;
                case 2:
                    myStack.removeFromStack(element);
                    break;
                case 3:
                    myStack.findTheBiggest();
                    break;
                default:
                    System.out.print("Такой операции не существует.");
            }

            System.out.println();
            System.out.println();

            question = true;
            System.out.println("Это все операции которые вы хотели сделать?");
            System.out.println("1 - Да");
            System.out.println("Любое другое целое число - Нет");
            menu = getInt();

            if ( menu == 1)
            {
                question = false;
            }
        } while (question);


        System.out.println();
        System.out.println();

        System.out.println("Результат программы ваш стэк: ");
        myStack.showStack();
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
