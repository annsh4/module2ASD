// ПП-11
// Горохов Данило
// Варіант 4 (6)

#include <iostream>
#include <vector>

#include "first_task/BinaryTree.h"


int main() {
    int choice;
    bool flag_choice = false;
    do{
        std::cout << "\n1 - Task 1: " << std:: endl;
        std::cout << "2 - Task 2: " << std:: endl;
        std::cout << "0 - Exit." << std::endl;
        std::cin >> choice;
        switch(choice){
            case 1: {
                int amountOfNodes, firstNumber, secondNumber;
                BinaryTree myTree;

                std::cout << "Enter an amount of nodes in the binary tree: " << std::endl;
                std::cin >> amountOfNodes;

                for(int i = 0; i < amountOfNodes; i++){
                    int nodeNumber;
                    std::cout << i + 1<< ". Enter a node number: " << std::endl;
                    std::cin >> nodeNumber;
                    myTree.addLeaf(nodeNumber);
                }

                std::cout << "Enter the first number of LCA: " << std::endl;
                std::cin >> firstNumber;
                std::cout << "Enter the second number of LCA: " << std::endl;
                std::cin >> secondNumber;

                std:: cout << "Your LCA will be: " <<  myTree.LCA(firstNumber, secondNumber)->data << std::endl;
                break;
            }
            case 2 : {
                int n1;
                int n2;
                int n3;
                std::cout << "Enter sizes of the N1, N2, N3 stacks: " << std::endl;
                std::cin >> n1 >> n2 >> n3;

                int weight1 = 0, weight2 = 0, weight3 = 0;
                std::vector<int> stack1(n1);

                for(int i = 0; i < n1; i++){
                    std::cout << "Enter number of the first stack: " << std::endl;
                    std::cin >> stack1[i];

                    weight1 += stack1[i];
                }
                std::vector<int> stack2(n2);
                for(int i = 0; i < n2; i++){
                    std::cout << "Enter number of the second stack: " << std::endl;
                    std::cin >> stack2[i];

                    weight2 += stack2[i];
                }
                std::vector<int> stack3(n3);
                for(int i = 0; i < n3; i++){
                    std::cout << "Enter number of the third stack: " << std::endl;
                    std::cin >> stack3[i];

                    weight3 += stack3[i];
                }

                bool equalWeight = false;
                if(weight1 == weight2 && weight2 == weight3) {
                    equalWeight = true;
                }

                int remove1 = 0, remove2 = 0, remove3 = 0;

                while(!equalWeight) {
                    if(weight1 >= weight2 && weight1 >= weight3) {
                        weight1 -= stack1[remove1];
                        remove1++;
                    } else if(weight2 >= weight1 && weight2 >= weight3) {
                        weight2 -= stack2[remove2];
                        remove2++;
                    } else if(weight3 >= weight1 && weight3 >= weight2) {
                        weight3 -= stack3[remove3];
                        remove3++;
                    }
                    if((weight1 == weight2 && weight2 == weight3) || (weight1 == 0 && weight2 == 0 && weight3 == 0)) {
                        equalWeight = true;
                    }
                }
                std::cout << "\nYour weight: " << weight1;
//                std::cout << "\nNew stacks: " << std::endl;
//
//                for(int i = 0; i < n1; i++){
//                    std::cout << '\t' << stack1[i];
//                }
//                std::cout << std::endl;
//                for(int i = 0; i < n2; i++){
//                    std::cout << '\t' << stack2[i];
//                }
//                std::cout << std::endl;
//                for(int i = 0; i < n3; i++){
//                    std::cout << '\t' << stack2[i];
//                }
//                std::cout << std::endl;
                break;
            }
            case 0 : {
                flag_choice = true;
                break;
            }
        }
    } while (!flag_choice);

    return 0;
}