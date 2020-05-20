package com.dmytro_khylko;

public class Stack{
    private class Node{
        int number;
        Node next;
        Node previous;
        Node(int number, Node previous, Node next){
            this.number = number;
            this.previous = previous;
            this.next = next;
        }
    }
    private Node head;
    private Node tail;
    private int Size;
    Stack(){
        this.head = null;
        this.tail = null;
        this.Size = 0;
    }
    public boolean isEmpty(){
        if(this.Size == 0) return true;
        else return false;
    }
    public int getSize(){
        return this.Size;
    }
    public void clear(){
        this.head = null;
        this.Size = 0;
        this.tail = null;
    }
    public void push(int number){
        if(isEmpty()){
            head = new Node(number, null, null);
            tail = head;
            Size++;
        }
        else{
            Node newNode = new Node(number, tail,null);
            tail = newNode;
            Size++;
        }
    }
    public void pop(){
        if(!isEmpty()) {
            tail = tail.previous;
            Size--;
        }
    }
    public void show(){
        Node current = this.tail;
        System.out.println("Elements of stack:");
        for(int i = 0; i < this.Size; i++){
            System.out.printf("%d ",current.number);
            if(current.previous == null){
                break;
            }
            current = current.previous;
        }
        System.out.println("");
    }
    public int getMaxElement(){
//        if(Index >= 0 && Index < this.Size){
//            Node current = head;
//            for(int i = 0; i < Index; i++){
//                current = current.next;
//            }
//            return current.number;
//        }else return Integer.MIN_VALUE;
        Node current = this.tail;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < this.Size; i++){
            if(current.number > maxValue){
                maxValue = current.number;
            }
            if(current.previous == null){
                break;
            }
            current = current.previous;
        }
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        return maxValue;
    }
}
