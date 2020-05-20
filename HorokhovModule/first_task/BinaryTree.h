//
// Created by Daniel on 5/20/2020.
//

#ifndef HOROKHOVMODULE_BINARYTREE_H
#define HOROKHOVMODULE_BINARYTREE_H

#include <iostream>

struct node{
    int data;
    node *left, *right;
};

class BinaryTree {
    node* root;
    node* searchLeaf(int key, node* leaf, int sticksCounter);
    node* LCA(node* root, int firstNumber, int secondNumber);

    void destroy_tree(node* leaf);
    void addLeaf(int key, node* leaf);
    void displayTree(const std::string &prefix, const node* leaf, bool isLeft);
public:
    BinaryTree();
    ~BinaryTree();

    void destroy_tree();
    void displayTree();
    void addLeaf(int key);
    node* LCA(int firstNumber, int secondNumber);
    node* searchLeaf(int key);
};


#endif //HOROKHOVMODULE_BINARYTREE_H
