package Test122;


import java.util.Scanner;

public class main {
    public static int a=0;
    public static list list = new list();
    public static list lis = new list();

    public static int Global(){
        a++;
        return a;
    }

    public static void Generat() {
        int a = 1;
        while (a <= 10) {
            lis.add(Global(), +a);
            a++;
        }
        System.out.println("Виводимо згенерований список ");
        lis.print();

        lis.change();//перетворюємо на двохзв’язний список

    }

    public static void menu(){
        try {
            Scanner sca =new Scanner(System.in);
            int chose=0;
            System.out.println("1-Start;");
            chose = sca.nextInt();
            switch (chose){
                case 1:
                    Generat();//Створюємо однозв'язний список 20 елементів і перетворюємо на двохзв’язний
                    break;
                case 4: System.exit(0);
                default:
                    menu();

            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Ви ввели невірні дані!");
            menu();
        }
    }


    public static void Delete(){

        list.remove();
        menu();
    }
    public static void main(String[] args) {
        menu();
    }
}


