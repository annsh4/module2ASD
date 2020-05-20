package com.company;

public class DoublyLinkedList {
    Node head, tail = null;

    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            head.previous = null;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        tail.next = null;
    }

    public void sortList() {
        Node current, index;
        int temp;
        if (head == null) {
            return;
        } else {
            for (current = head; current.next != null; current = current.next) {
                for (index = current.next; index != null; index = index.next) {
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                }
            }
        }
    }

    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("Список порожній");
            return;
        }
        System.out.println("Ваш список: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
