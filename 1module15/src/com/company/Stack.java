package com.company;

public class Stack {
    static final int MAX = 9999;
    int top;
    int[] maxSizeOfStack = new int[MAX];

    Stack() {
        top = -1;
    }

    boolean isEmpty() {
        return (top < 0);
    }

    boolean push(int value) {
        if (top >= MAX - 1) {
            System.out.println("Переповнення стеку");
            return false;
        } else {
            maxSizeOfStack[++top] = value;
            return true;
        }
    }

    int pop() {
        if (top < 0) {
            System.out.println("Вихід за нижню границю стека");
            return 0;
        } else {
            return maxSizeOfStack[top--];
        }
    }

    int peek() {
        if (top < 0) {
            System.out.println("Вихід за нижню границю стека");
            return 0;
        } else {
            return maxSizeOfStack[top];
        }
    }
}
