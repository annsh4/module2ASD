#include<iostream.h>
#include <windows.h>

// ПП-11
// Грицунь Ярослав
// Варіант 2 (7)

using namespace std;
#define MAX 1000

class Stack {
    int top;

public:
	int a[MAX];

    Stack() { top = -1; }
    bool push(int x);
    int pop();
    int peek();
    bool isEmpty();
};

bool Stack::push(int x)
{
	if (top >= (MAX - 1)) {
        return false;
    }
    else {
		a[++top] = x;
        return true;
    }
}

int Stack::pop()
{
	if (top < 0) {
		return 0;
	}
    else {
        int x = a[top--];
        return x;
    }
}
int Stack::peek()
{
    if (top < 0) {
		cout << "Стек порожній";
        return 0;
    }
    else {
        int x = a[top];
        return x;
    }
}

bool Stack::isEmpty()
{
    return (top < 0);
}

int main()
{
	SetConsoleOutputCP(1251);
	puts("Уведіть кількість елементів у трьох стеках з нових рядків:");
	int n1, n2, n3;
	cin>>n1;
	cin>>n2;
	cin>>n3;
	class Stack stack1;
	class Stack stack2;
	class Stack stack3;
	int *st1 = new int [n1];
	int *st2 = new int [n2];
	int *st3 = new int [n3];
	puts("Розпочинайте введення елементів першого стеку:");
	int num, sum1=0, sum2=0, sum3=0;
	for(int i = 0; i < n1; i++){
		cin>>num;
	   stack1.push(num);
	   sum1+=num;
	   st1[i]=num;

	}
	puts("Розпочинайте введення елементів другого стеку:");
	for(int i = 0; i < n2; i++){
		cin>>num;
	   stack2.push(num);
	   sum2+=num;
	   st2[i]=num;

	}
	puts("Розпочинайте введення елементів третього стеку:");
	for(int i = 0; i < n3; i++){
		cin>>num;
	   stack3.push(num);
	   sum3+=num;
	   st3[i]=num;

	}
	while(true){
		if(sum1==sum2&&sum2==sum3)
			break;
		if(sum1<sum2){
			sum2 -=stack2.peek();
			stack2.pop();
		 }
		if(sum1<sum3){
			sum3-=stack3.peek();
			stack3.pop();
		}
		if(sum2<sum1){
			 sum1 -=stack1.peek();
			 stack1.pop();
		}
		if(sum2<sum3){
			  sum3 -=stack3.peek();
			  stack3.pop();
		}
		if(sum3<sum1){
			 sum1 -=stack1.peek();
			 stack1.pop();
		}
		if(sum3<sum2){
			sum2 -=stack2.peek();
			stack2.pop();
		}
	}
	cout<<"Виведення максимальної спільної ваги при якій стеки будуть дорівнювати одне одному: "<<sum1<<endl;
	puts("Виведення елементів першого стеку до вирівнювання:");
	for(int i = n1-1; i >=0; i--){
		cout<<st1[i]<<" ";

	}
	cout<<endl;
	puts("Виведення елементів другого стеку до вирівнювання:");
	for(int i = n2-1; i >=0; i--){
		cout<<st2[i]<<" ";
	}
	cout<<endl;
	puts("Виведення елементів третього стеку до вирівнювання");
	for(int i = n3-1; i >=0; i--){
		cout<<st3[i]<<" ";
	}
	cout<<endl;
	puts("Виведення елементів першого стеку після вирівнювання:");
	while(!(stack1.isEmpty())){
		cout<<stack1.pop()<<" ";
	}
	cout<<endl;
	puts("Виведення елементів другого стеку після вирівнювання:");
	while(!(stack2.isEmpty())){
		cout<<stack2.pop()<<" ";
	}
	cout<<endl;
	puts("Виведення елементів третього стеку після вирівнювання:");
	while(!(stack3.isEmpty())){
		cout<<stack3.pop()<<" ";
	}
    cout<<endl;
   system("pause");
   return 0;
}
