//ПП11
//Риков Владисла
//Варіант 5 (14)

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        // я решил что закоментить (не)нужное проще и удобнее чем создавать 2 отдельных прокта
    }

    public static Scanner in = new Scanner(System.in);

    public static void task1() {
        try {
            int act, value;

            System.out.println("Введите кол-во действий");
            int sumAct = in.nextInt();

            Stack stack = new Stack();

            for (int i = 0; i < sumAct; i++) {
                System.out.println("print act and number");
                act = in.nextInt();
                switch (act) {
                    case 1:
                        value = in.nextInt();
                        stack.add(value);
                        stack.print();
                        break;
                    case 2:
                        stack.remove();
                        stack.print();
                        break;
                    case 3:
                        System.out.println(stack.getBiggest());
                        break;
                    default:
                        System.out.println("юзер не самый умный");
                        break;
                }
            }
        } catch (
                InputMismatchException e) {
            System.out.println("юзер не самый умный");
        }
    }

    public static void task2() {
        try {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

            System.out.print("Введите N = ");
            int N = in.nextInt();

            System.out.println("Теперь вводите " + N + " елем");
            for (int i = 0; i < N; i++) {
                int value = in.nextInt();
                doublyLinkedList.addNode(value);
            }
            doublyLinkedList.printDLL();

            System.out.print("а теперь(не доконца понял в чем смысл но ладно), ADD = ");
            int ADD = in.nextInt();
            System.out.println("Теперь вводите " + ADD + " елем");
            for (int i = 0; i < ADD; i++) {
                int value = in.nextInt();
                doublyLinkedList.addNode(value);
            }
            doublyLinkedList.printDLL();

            System.out.println("Происходит сортировка листа***");
            doublyLinkedList.sortList();
            doublyLinkedList.printDLL();

        } catch (InputMismatchException e) {
            System.out.println("юзер не самый умный");
        }
    }

}
