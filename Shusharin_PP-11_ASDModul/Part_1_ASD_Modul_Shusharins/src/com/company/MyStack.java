package com.company;
import java.util.LinkedList;
import java.util.Scanner;

public class MyStack {

    LinkedList<Integer> stack = new LinkedList<>();

//    protected int getOperation()
//    {
//        int numberOfOperation;
//        numberOfOperation = getInt();
//        return numberOfOperation;
//    }
//
//    protected int getElement()
//    {
//        int element;
//        element = getInt();
//        return element;
//    }


    protected int firstCheck(int numberOfOperation)
    {
        if (numberOfOperation != 1)
        {
            System.out.println("Ваш стек пустой, ваша операция под номером " + numberOfOperation + " будет" +
                    " автоматически изменена на операцыю под номером 1");
            numberOfOperation = 1;
        }
        return numberOfOperation;
    }

    protected void addToStack(int element)
    {
        stack.addFirst(element);
    }


    protected void removeFromStack(int element)
    {
        if (stack.contains(element)) {
            if (stack.indexOf(element) == 0) {
                stack.remove(stack.indexOf(element));
            } else System.out.println("Данный элемент невозможно удалить, так как он не является первым в стэке");
        } else System.out.println("Данный элемент не найден");
    }

    protected void findTheBiggest()
    {
        int length = stack.size();
        Integer[] arrayFromStack = stack.toArray(new Integer[length]);
        for (int i = 0; i < arrayFromStack.length-1; i++)
        {
            int min = i;
            for (int j = i+1; j < arrayFromStack.length; j++)
            {
                if (arrayFromStack[j] < arrayFromStack[min])
                    min = j;
            }

            int temp = arrayFromStack[min];
            arrayFromStack[min] = arrayFromStack[i];
            arrayFromStack[i] = temp;
        }

        System.out.print("Найбольший элемент стэка: " + arrayFromStack[length-1]);
    }

    protected void showStack()
    {
        int length = stack.size();
        for (int i = 0; i < length; i++)
        {
            System.out.println(stack.get(i));
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
