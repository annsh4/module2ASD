
//
// Вариант 6 Работа Харламова Игоря задание 2
//

import java.util.Scanner;

public class Task_2 {

    public static int size_1;
    public static Stack stack_1;

    public static int size_2;
    public static Stack stack_2;

    public static int size_3;
    public static Stack stack_3;

    static public int[] getSegments(Stack stack) {
        int[] segments = new int[stack.count()];
        for (int i=0; i < segments.length; i++)
            segments[i] = stack.getSumOnSegment(i+1);
        return segments;
    }

    static public int check_int_number() {
        int chosen_num;
        while (true) {
            Scanner num_1 = new Scanner(System.in);
            if (num_1.hasNextInt()) {
                chosen_num = num_1.nextInt();
                break;
            }
            System.out.println("date incorrect");
        }
        return chosen_num;
    }

    public static class Stack{
        private int max_size;
        private int[] stack_array;
        private int end_num;

        public Stack(int max_size){
            this.max_size=max_size;
            stack_array = new int[max_size];
            end_num=-1;
        }

        public void Push(int element){
            if(!isFull()) {
                stack_array[++end_num] = element;
            }else{
                System.out.println("Стэк полон");
            }
        }

        public int Pop(){
            if(!isEmpty())
                return stack_array[end_num--];
            else{
                System.out.println("Стэк пуст");
                return 0;
            }
        }

        public int getSumOnSegment(int end) {
            int sum = 0;
            for (int i=0; i < end; i++)
                sum += stack_array[i];
            return sum;
        }

        public int count() {
            return end_num + 1;
        }

        public int getElement(int i) {
            return stack_array[i];
        }

        public int getEnd_num(){
            return stack_array[end_num];
        }

        public boolean isEmpty(){
            return (end_num==-1);
        }

        public boolean isFull(){
            return (end_num == max_size-1);
        }
    }
    public static void Menu_Stack(){

        System.out.println("Введите размер стэка  1");
        size_1 = check_int_number();
        stack_1 = new Stack(size_1);
        System.out.println("Введите размер стэка  2");
        size_2 = check_int_number();
        stack_2 = new Stack(size_2);
        System.out.println("Введите размер стэка  3");
        size_3 = check_int_number();
        stack_3 = new Stack(size_3);

        for(int i : stack_1.stack_array) {
            System.out.println("Введите число для 1 стэка");
            int value = check_int_number();
            stack_1.Push(value);
        }
        for(int i : stack_2.stack_array) {
            System.out.println("Введите число для 2 стэка");
            int value = check_int_number();
            stack_2.Push(value);
        }
        for(int i : stack_3.stack_array) {
            System.out.println("Введите число для 3 стэка");
            int value = check_int_number();
            stack_3.Push(value);
        }

        int[] segments_1 = getSegments(stack_1);
        int[] segments_2 = getSegments(stack_2);
        int[] segments_3 = getSegments(stack_3);

        int max = 0;
        int trunc_1 = 0, trunc_2 = 0, trunc_3 = 0;
        for (int i = 0; i < segments_1.length; i++)
            for (int j = 0; j < segments_2.length; j++)
                for (int k = 0; k < segments_3.length; k++)
                    if (segments_1[i] == segments_2[j] && segments_2[j] == segments_3[k]) {
                        max = segments_1[i];
                        trunc_1 = i + 1;
                        trunc_2 = j + 1;
                        trunc_3 = k + 1;
                    }

        System.out.printf("Максимальный общий вес - %d\n", max);
        System.out.println("Стэки:");
        for (int i=0; i < trunc_1; i++)
            System.out.printf("%d ", stack_1.getElement(i));
        System.out.println();
        for (int i=0; i < trunc_2; i++)
            System.out.printf("%d ", stack_2.getElement(i));
        System.out.println();
        for (int i=0; i < trunc_3; i++)
            System.out.printf("%d ", stack_3.getElement(i));
        System.out.println();
    }

    public static void main(String[] args) {
        Menu_Stack();
    }
}