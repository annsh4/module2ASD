import java.util.Scanner;

//
// Вариант 6 Работа Харламова Игоря задание 1
//

public class Task_1 {
     public static int size;
    public static Stack stack;

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
            if(!isEmpty()) {
               return stack_array[end_num--];
            } else{
                System.out.println("Стэк пуст");
                return 0;
            }
        }
        public int Max_value(){
            int max_value = Integer.MIN_VALUE;
            for (int value : stack_array) {
                if (value > max_value)
                    max_value = value;
            }
            return max_value;
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

        public void Show_stack_array(){
            while (!stack.isEmpty()){
                int value = stack.Pop();
                System.out.print(value);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }

    public static void Menu_Stack(){
        System.out.println("Введите размер стэка");
        size = check_int_number();
        stack = new Stack(size);
        int switch_number;
        do {
            System.out.println("Введите метод, который хочете использовать, 0 - выход из программы");
            switch_number=check_int_number();
            switch (switch_number) {
                case 1:
                    method_1();
                    break;
                case 2:
                    method_2();
                    break;
                case 3:
                    method_3();
                    break;
            }
        }while (switch_number!=0);
        stack.Show_stack_array();
    }
    public  static void method_1(){
        System.out.println("Вызван 1 метод введите число");
        int element = check_int_number();
        stack.Push(element);
    }
    public static void method_2(){
        System.out.println("Вызван 2 метод, число удалено");
        stack.Pop();
    }
    public static void method_3(){
        System.out.println("Вызван 3 метод");
       int max_value = stack.Max_value();
       if(max_value!=Integer.MIN_VALUE)
           System.out.println("Максимальное число в этом стэке - " + max_value);
       else System.out.println("Елементов нету");
    }

    public static void main(String[] args) {
        Menu_Stack();
    }
}
