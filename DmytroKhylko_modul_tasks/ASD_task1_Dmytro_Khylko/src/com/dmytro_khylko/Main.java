// ПП - 11
// Хилько Дмитро
// Варіант 1(17)
// Завдання 1
package com.dmytro_khylko;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
    Stack stack = new Stack();
        List<Integer> maxValuesOfStack = new LinkedList<>();
        System.out.println("To exit program and get information input 0");
        while(true) {
            int numberOfOperation = getOperationNumber();
            switch (numberOfOperation){
                case 0:
                    System.out.println(maxValuesOfStack);
                    System.exit(0);
                case 1:
                    stack.push(getNumber());
                    continue;
                case 2:
                    stack.pop();
                    continue;
                case 3:
                    int maxValue = stack.getMaxElement();
                    if(!stack.isEmpty()) {
                        System.out.println(maxValue);
                        maxValuesOfStack.add(maxValue);
                    }
            }
        }
    }
    public static int getOperationNumber(){
        int numberOfOperation = -1;
        boolean error;
        do {
            try {
                numberOfOperation = sc.nextInt();
                error = false;
                if(numberOfOperation == 1 || numberOfOperation == 2 || numberOfOperation == 3 || numberOfOperation == 0){
                    return numberOfOperation;
                }
                    System.out.println("Wrong number of operation. Input again");
            } catch (InputMismatchException e) {
                error = true;
                System.out.println("Input error");
                sc.next();
            }
        } while (error || numberOfOperation == -1);
        return numberOfOperation;
    }

    public static int getNumber(){
        int number = Integer.MIN_VALUE;
        boolean error;
        do {
            try {
                number = sc.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                error = true;
                System.out.println("Input error");
                sc.next();
            }
        } while (error);
        return number;
    }
}

