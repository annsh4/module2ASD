package com.company;

public class BinaryTree {
    Nodes root;
    /**
     * Пошук елементу в дереві за ключем
     * @param key
     * @return
     */
    public Nodes find(int key){
        Nodes current = root;
        while(current.key!=key){
            if(current.key<key){
                current = current.leftChild;
            }else{
                current = current.rightChild;
            }
            if(current==null){
                return null;
            }
        }
        return current;
    }

    /**
     * Вставка в дерево. Як пошук, але замість виведення елементу
     * до нього додається (правим або лівим) потомком новий елемент
     * @param key
     * @param data
     */
    public void insert(int key, String data){
        Nodes node = new Nodes();
        node.key = key;
        node.data = data;
        if(root==null){
            root = node;
        }else{
            Nodes current = root;
            Nodes prev = null;
            while (true){
                prev = current;
                if(key<prev.key){
                    current = current.leftChild;
                    if(current==null){
                        prev.leftChild = node;
                        return;
                    }
                }else{
                    current = current.rightChild;
                    if(current==null){
                        prev.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    /**
     * виведення всіх елементів дерева (асиметричним обходом)
     * @param startNode
     */
    public void print(Nodes startNode){
        if(startNode != null){//true, коли досягнеться кінець дерева (потомків не залишиться)
            print(startNode.leftChild);//рекурсивний виклик лівих нащадків
            startNode.printNode();//виклик метода друку
            print(startNode.rightChild);//виклик правих дітей
        }
    }
}
