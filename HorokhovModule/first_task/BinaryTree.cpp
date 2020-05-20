//
// Created by Daniel on 5/20/2020.
//

#include "BinaryTree.h"

BinaryTree::BinaryTree() {
    root = NULL;
}

BinaryTree::~BinaryTree() {
    destroy_tree();
}

void BinaryTree::destroy_tree() {
    destroy_tree(root);
}

void BinaryTree::destroy_tree(node *leaf) {
    if(leaf != NULL){
        destroy_tree(leaf->right);
        destroy_tree(leaf->left);
        delete leaf;
    }
}

void BinaryTree::addLeaf(int key, node *leaf) {

    if(root == nullptr){
        node* temp = new node;
        root = temp;
        root->data = key;
        root->left = root->right = NULL;
    }else if(key < leaf->data){
        if(leaf->left != NULL){
            addLeaf(key, leaf->left);
        } else {
            leaf->left = new node;
            leaf->left->data = key;
            leaf->left->left = NULL;
            leaf->left->right = NULL;
        }
    } else if (key >= leaf->data){
        if(leaf->right != NULL){
            addLeaf(key, leaf->right);
        } else {
            leaf->right = new node;
            leaf->right->data = key;
            leaf->right->left = NULL;
            leaf->right->right = NULL;
        }
    }
}

void BinaryTree::addLeaf(int key) {
    addLeaf(key, root);
}

node* BinaryTree::searchLeaf(int key, node *leaf, int sticksCounter) {
    if (leaf != NULL){
        if(key == leaf->data) {
            std::cout << "Amount of sticks to the " << key << " in the Binary Tree: " << sticksCounter << std::endl;
            return leaf;
        }
        if (key < leaf->data) {
            sticksCounter++;
            return searchLeaf(key, leaf->left, sticksCounter);
        } else {
            sticksCounter++;
            return searchLeaf(key, leaf->right, sticksCounter);
        }
    }
    else
        return NULL;
}

node* BinaryTree::searchLeaf(int key) {
    searchLeaf(key, root, 0);
}


void BinaryTree::displayTree(const std::string &prefix, const node* leaf, bool isLeft) {
    if( leaf != nullptr )
    {
        std::cout << prefix;

        std::cout << (isLeft ? "├──" : "└──" );

        std::cout << leaf->data << std::endl;

        displayTree( prefix + (isLeft ? "│   " : "    "), leaf->left, true);
        displayTree( prefix + (isLeft ? "│   " : "    "), leaf->right, false);
    }
}

void BinaryTree::displayTree() {
    displayTree("", root, false);
}

node* BinaryTree::LCA (int firstNumber, int secondNumber){
    LCA(root, firstNumber, secondNumber);
}

node* BinaryTree::LCA (node* leaf, int firstNumber, int secondNumber){
    if(leaf == NULL) return NULL;

    if(leaf->data > firstNumber && leaf->data > secondNumber)
        return LCA(leaf->left, firstNumber, secondNumber);

    if(leaf->data < firstNumber && leaf->data < secondNumber)
        return LCA(leaf->right, firstNumber, secondNumber);

    return leaf;
};