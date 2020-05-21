package com.dmytro_khylko;


////  !!!!!!!!  TASK 2 functions are in the bottom ///////////
public class BinaryTree{
    private class Node{
        Node left, right;
        int data, height;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
            height = 1;
        }
    }
    public Node root;
    public BinaryTree(){
        this.root = null;
    }

    private int minValue(Node temp){
        int minValue = temp.data;
        while(temp.left != null){
            minValue = temp.left.data;
            temp = temp.left;
        }
        return minValue;
    }
    public void insert(int value){
        root = insertNode(root, value);
    }
    private Node insertNode(Node root, int value){
        if(root == null){
            root = new Node(value);
            return root;
        }
        if(value < root.data){
            root.left = insertNode(root.left, value);
        }else if(value > root.data){
            root.right = insertNode(root.right, value);
        }else System.out.println("Element "+ value +" already exists in tree");

        return root;
    }
    public boolean contains(int value){
        return check(root, value);
    }
    private boolean check(Node root, int value){
        if(value == root.data){
            return true;
        } else if(value < root.data){
            if(root.left == null){
                return false;
            }else{
                return check(root.left, value);
            }
        }else {
            if(root.right == null){
                return false;
            }else{
                return check(root.right, value);
            }
        }
    }
    public void printInOrder(){
        Node root = this.root;
        if(root == null){
            System.out.println("Tree is empty");
        }else
            InOrder(root);
    }
    private void InOrder(Node root){
        if (root != null)
        {
            InOrder(root.left);
            System.out.println(root.data);
            InOrder(root.right);
        }
    }
    public void delete(int value){
        root = deleteNode(this.root, value);
    }
    private Node deleteNode(Node temp, int value){
        if(temp == null){
            return temp;
        }else if(temp.data == value){
            if (temp.left == null)
                return temp.right;
            else if (temp.right == null)
                return temp.left;

            temp.data = minValue(temp.right);
            temp.right = deleteNode(temp.right, temp.data);
        }else if(value < temp.data){
            temp.left = deleteNode(temp.left, value);
        }else if(value > temp.data){
            temp.right = deleteNode(temp.right, value);
        }
        if (root == null)
            return root;
        return temp;
    }

    ////// TASK 2 functions ///////
    public Node findLCA(int firstNodeValue, int secondNodeValue){
        Node resultNode = findLCA_private(root, firstNodeValue, secondNodeValue);
        if(resultNode != null)
            System.out.println("LCA value = " + resultNode.data);
        return resultNode;
    }
    private Node findLCA_private(Node node, int firstNodeValue, int secondNodeValue){
        if(!contains(firstNodeValue) || !contains(secondNodeValue)){
            System.out.println("Cant find nodes. Try again");
            return null;
        }
        if (node == null)
            return null;

        if (node.data == firstNodeValue || node.data == secondNodeValue)
            return node;

        Node leftLCA = findLCA_private(node.left, firstNodeValue, secondNodeValue);
        Node rightLCA = findLCA_private(node.right, firstNodeValue, secondNodeValue);

        if (leftLCA != null && rightLCA != null)
            return node;

        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}

