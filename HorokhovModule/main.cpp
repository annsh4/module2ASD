// ПП-11
// Горохов Данило
// Варіант 4 (6)

#include <iostream>
#include "first_task/BinaryTree.h"
#include "second_task/Stack.h"

int main() {
    int choice;
    bool flag_choice = false;
    do{
        std::cout << "1 - Task 1: " << std:: endl;
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
                const int AMOUNT_OF_STACKS = 3;
                int stackSize[AMOUNT_OF_STACKS];

                std::cout << "Enter N1 stack size: " << std::endl;
                std::cin >> stackSize[0];
                std::cout << "Enter N2 stack size: " << std::endl;
                std::cin >> stackSize[1];
                std::cout << "Enter N3 stack size: " << std::endl;
                std::cin >> stackSize[2];

                Stack* arrayOfStacks = new Stack[AMOUNT_OF_STACKS];

                for (int i = 0; i < AMOUNT_OF_STACKS; i++){
                    arrayOfStacks[i] = Stack(stackSize[i]);
                }

                for(int i = 0; i < AMOUNT_OF_STACKS; i++){
                    for(int j = 0; j < stackSize[i]; j++){
                        int weightNumber;
                        std::cout << "Input the weight of N" << i+1 <<" array number: " << std:: endl;
                        std::cin >> weightNumber;
                        arrayOfStacks[i].push(weightNumber);
                    }
                    std::cout << "--------------------------------" << std::endl;
                }

                for(int i = 0; i < AMOUNT_OF_STACKS; i++){
                    std::cout << "Summary weight of each stack(N" << i+1 << "): " <<
                              arrayOfStacks[i].getWeightSum() << std::endl;
                }

                for(int i = 0; i < AMOUNT_OF_STACKS; i++){
                    std::cout << '\n';
                    arrayOfStacks[i].displayStack();
                }
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