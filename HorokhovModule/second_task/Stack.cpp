//
// Created by Daniel on 5/20/2020.
//

#include "Stack.h"

Stack::Stack(){
    stackArray = NULL;
    size = 0;
    top = 0;
}

Stack::Stack(int inputSize) {
    stackArray = new int[inputSize];
    size = inputSize;
    top = -1;
}

Stack::Stack(const Stack &obj){
    if(obj.size > 0){
        stackArray = new int[obj.size];
    } else {
        stackArray = NULL;
    }
    size = obj.size;

    for(int i = 0; i < size; i++){
        stackArray[i] = obj.stackArray[i];
    }
    top = obj.top;
}

Stack::~Stack() {
    delete [] stackArray;
}

void Stack::push(int number){
    if(isFull()){
        std::cout << "The stack is full." << std::endl;
    } else {
        top++;
        stackArray[top] = number;
    }
}

void Stack::pop(int &number) {
    if(isEmpty()){
        std::cout << "The stack is empty." << std::endl;
    } else {
        number = stackArray[top];
        top--;
    }
}

bool Stack::isFull() {
    bool status;

    if (top == size - 1){
        status = true;
    } else {
        status = false;
    }

    return status;
}

bool Stack::isEmpty() {
    bool status;

    if (top == -1){
        status = true;
    } else {
        status = false;
    }

    return status;
}

void Stack::displayStack() {
    for(int i = 0; i < size; i++){
        if (!isEmpty()) {
            std::cout << stackArray[i] << '\t';
        } else {
            std::cout << "Array is empty." << std::endl;
        }
    }
    std::cout << std::endl;
}

int Stack::getWeightSum(){
    weightSum = calculateWeightSum();
    return weightSum;
}

int Stack::calculateWeightSum() {
    if(isEmpty()) return 0;

    int sum = 0;
    for(int i = 0; i < size; i++){
        sum += stackArray[i];
    }

    return sum;
}