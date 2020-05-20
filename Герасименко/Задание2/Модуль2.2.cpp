#include <iostream>

using namespace std;

class Node {
	int value;
	Node* left;
	Node* right;
	Node* parent;
public:
	Node() {
		this->value = 0;
		this->left = nullptr;
		this->right = nullptr;
		this->parent = nullptr;
	}
	Node* addNode(int value, Node* tree) {
		if (tree == NULL) {
			tree = new Node;
			tree->value = value;
			tree->left = tree->right = NULL;
			tree->parent = NULL;
		}
		else  if (value < tree->value) {
			tree->left = addNode(value, tree->left);
			tree->left->parent = tree;
			cout << "left node: " << tree->left->value << endl;
			cout << "left node parent: " << tree->left->parent->value << endl;
		}
		else {
			tree->right = addNode(value, tree->right);
			tree->right->parent = tree;
			cout << "right node: " << tree->right->value << endl;
			cout << "right node parent: " << tree->right->parent->value << endl;
		}
		return(tree);
	}
	void remove(Node* tree) {
		if (tree != NULL) {
			remove(tree->left);
			remove(tree->right);
			delete tree;
		}
	}
	void treeprint(Node* p) {
		if (p != NULL) {
			treeprint(p->left);
			cout << p->value << endl;
			treeprint(p->right);
		}
	}
	Node* findNode(Node* p, int val) {
		if (p != NULL) {
			if (p == 0 || p->value == val) {
				return p;
			}
			if (p->value > val) {
				return findNode(p->left, val);
			}
			else {
				return findNode(p->right, val);
			}
		}
	}
	int getData(Node* node) {
		if (node == nullptr) {
			cout << "there is no such node!" << endl;
			return -1;
		}
		return node->value;
	}
	int findMinParent(Node* lhs, Node* rhs) {
		//cout << "lhs: " << getData(lhs) << endl;
		//cout << "rhs: " << getData(rhs) << endl;
		if (lhs->parent == NULL || rhs->parent == NULL) {
			cout << "There is no parent of this node!" << endl;
			return -1;
		}
		if (lhs->parent == rhs->parent) {
			return rhs->parent->value;
		}
		else {
			lhs = lhs->parent;
			rhs = rhs->parent;
			return findMinParent(lhs, rhs);
		}
	}
};



int main()
{
	int n;
	cout << "Enter a number of nodes: ";
	cin >> n;
	Node* root;
	Node tree;
	root = NULL;
	int value;
	cout << "Enter values of nodes: " << endl;
	for (int i = 0; i < n; ++i) {
		cin >> value;
		root = tree.addNode(value, root);
	}

	cout << "Enter nodes you want to get minimum common parent: "  << endl;
	int v1, v2;
	cin >> v1 >> v2;
	Node* lhs = tree.findNode(root, v1);
	Node* rhs = tree.findNode(root, v2);
	cout << "Minimum common parent: " << tree.findMinParent(lhs, rhs) << endl;

	cout << "Binary Tree: " << endl;
	tree.treeprint(root);
	tree.remove(root);

	return 0;
}
