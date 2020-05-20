//
//  main.cpp
//  asd module 2 task 2 variant 4
//
//  Created by Admin on 5/20/20.
//  Copyright © 2020 Admin. All rights reserved.
//

#include <iostream>

using namespace std;

#define MAX 1000

class Stack {
    int top;

public:
    int a[MAX];

    Stack() { top = -1; }
    bool push(int x);
    int pop();
    int pk();
    bool isEmpty();
};

bool Stack::push(int x){
    if (top >= (MAX - 1)) {
        return false;
    }
    else {
        a[++top] = x;
        return true;
    }
}

int Stack::pop(){
    if (top < 0) {
        return 0;
    }
    else {
        int x = a[top--];
        return x;
    }
}
int Stack::pk(){
    if (top < 0) {
        cout << "Stack is empty!";
        return 0;
    }
    else {
        int x = a[top];
        return x;
    }
}

bool Stack::isEmpty(){
    return (top < 0);
}

int main(){
    cout<<"Enter number of 3 stack:";
    int n1, n2, n3;
    cin>>n1;
    cin>>n2;
    cin>>n3;
    class Stack stck1;
    class Stack stck2;
    class Stack stck3;
    int *st1 = new int [n1];
    int *st2 = new int [n2];
    int *st3 = new int [n3];
    cout<<"Enter number of first stack:";
    int num, sum1=0, sum2=0, sum3=0;
    for(int i = 0; i < n1; i++){
        cin>>num;
       stck1.push(num);
       sum1+=num;
       st1[i]=num;

    }
    cout<<"Enter number of second stack:";
    for(int i = 0; i < n2; i++){
        cin>>num;
       stck2.push(num);
       sum2+=num;
       st2[i]=num;

    }
    cout<<"Enter number of third stack:";
    for(int i = 0; i < n3; i++){
        cin>>num;
       stck3.push(num);
       sum3+=num;
       st3[i]=num;

    }
    while(true){
        if(sum1==sum2&&sum2==sum3)
            break;
        if(sum1<sum2){
            sum2 -=stck2.pk();
            stck2.pop();
         }
        if(sum1<sum3){
            sum3-=stck3.pk();
            stck3.pop();
        }
        if(sum2<sum1){
             sum1 -=stck1.pk();
             stck1.pop();
        }
        if(sum2<sum3){
              sum3 -=stck3.pk();
              stck3.pop();
        }
        if(sum3<sum1){
             sum1 -=stck1.pk();
             stck1.pop();
        }
        if(sum3<sum2){
            sum2 -=stck2.pk();
            stck2.pop();
        }
    }
    cout<<"Max weight all stack: "<<sum1<<endl;
    cout<<"Output of the elements of the first stack to align:";
    for(int i = n1-1; i >=0; i--){
        cout<<st1[i]<<" ";

    }
    cout<<endl;
    cout<<"Output of the elements of the second stack to align:";
    for(int i = n2-1; i >=0; i--){
        cout<<st2[i]<<" ";
    }
    cout<<endl;
        cout<<"Output of the elements of the third stack to align:";
    for(int i = n3-1; i >=0; i--){
        cout<<st3[i]<<" ";
    }
    cout<<endl;
        cout<<"first stack:";
    while(!(stck1.isEmpty())){
        cout<<stck1.pop()<<" ";
    }
    cout<<endl;
    cout<<"second stack:";
    while(!(stck2.isEmpty())){
        cout<<stck2.pop()<<" ";
    }
    cout<<endl;
    cout<<"third stack:";
    while(!(stck3.isEmpty())){
        cout<<stck3.pop()<<" ";
    }
    cout<<endl;
   system("pause");
   return 0;
}
