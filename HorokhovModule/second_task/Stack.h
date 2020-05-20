//
// Created by Daniel on 5/20/2020.
//

#ifndef HOROKHOVMODULE_STACK_H
#define HOROKHOVMODULE_STACK_H

#include <iostream>
#include <stack>

class Stack {
    int size, top;
    int* stackArray;
    int weightSum;

public:
    Stack();
    Stack(int);
    Stack(const Stack &);
    ~Stack();

    bool isEmpty();
    bool isFull();
    void push(int number);
    void pop(int &);
    void displayStack();

    int calculateWeightSum();
    int getWeightSum();
};


#endif //HOROKHOVMODULE_STACK_H
