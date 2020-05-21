package com.company;

public class Nodes {
    public int key; //ключ вузла
    public String data; //деякі дані у вузлі
    public Nodes leftChild; //лівий потомок
    public Nodes rightChild; //правий потомок

    /**
     * Метод виведення на екран вмісту вузла
     */
    public void printNode(){
        System.out.println("KEY " + key + " DATA: " + data);
    }
}
