import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

// ПП-11 Грищенко Богдан.... Варіант№5(8 у списку)
public class Main {
    public static ArrayList<String> myList = new ArrayList<>();
    public static void main(String[] args) {

        System.out.println("Завдання 1");
        System.out.println("Введіть розмір стеку");
        int size = 0;
        try {
            Scanner input = new Scanner(System.in);
            size = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Сталось щось погане");
            System.exit(0);
        }
        System.out.println("Розмір стеку:" + size);
        Exercise1 ex1 = new Exercise1(size);
        System.out.println("Стек створено....");
        MENU1(ex1);
        }
    public static void MENU1(Exercise1 ex1) {
        System.out.println("Введіть бажану дію:");
        System.out.println("1.Додавання елементу.");
        System.out.println("2.Видалення елементу.");
        System.out.println("3.Виведення найбільшого значення стеку.");
        System.out.println("4.Змінити стек.");
        System.out.println("0.Перейти до завдання №2.");
        System.out.println("5.Вихід.");
        Scanner input = null;
        int num = 0;
        try {
            input = new Scanner(System.in);
            num = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Помилка!!!!!!!!!!!!");
            MENU1(ex1);
        }
        try {
            switch (num) {
                case 1:
                    if(ex1.isFull()){
                        System.out.println("Стек заповнений!!");
                        MENU1(ex1);
                    }
                    System.out.println("Введіть число, яке бажаєте додати.");
                    int x = input.nextInt();
                    ex1.toAddElementToStack(x);
                    System.out.println("Число " + x + " додано...");
                    MENU1(ex1);
                    break;
                case 2:
                    System.out.println("Видалення елементу...");
                    if(ex1.isEmpty()){
                        System.out.println("Стек порожній!");
                        MENU1(ex1);
                    }
                    ex1.toDeleteElementFromStack();
                    MENU1(ex1);
                    break;
                case 3:
                    int maxvalue=Integer.MIN_VALUE;
                    System.out.print("Наш стек: ");
                    if (ex1.isEmpty()){
                        System.out.println("Стек порожній!");
                        MENU1(ex1);
                    }
                    while (!ex1.isEmpty()) {
                        if(maxvalue<ex1.toDisplayTop())
                        {
                            maxvalue=ex1.toDisplayTop();
                        }
                        int number = ex1.toDeleteElementFromStack();
                        System.out.print(number);
                        System.out.print(" ");
                    }
                    System.out.println("");
                    System.out.println("Максимальне значення: "+maxvalue +" у цьому стеці" );

                    System.out.println();
                    MENU1(ex1);
                    break;
                case 4:
                    System.out.println("Змінити розмір стеку");
                    int size = input.nextInt();
                    System.out.println("Розмір стеку:" + size);
                    ex1 = new Exercise1(size);
                    System.out.println("Стек створено!");
                    MENU1(ex1);
                    break;
                case 5:
                    System.out.println("ВИХІД.....");
                    System.exit(0);
                    break;
                case 0:
                    MENU2(ex1);
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Якась помилка!");
            MENU1(ex1);
        }
    }
    public static void MENU2(Exercise1 ex1){
        System.out.println();
        System.out.println("Завдання 2");
        System.out.println("Введіть бажану дію:");
        System.out.println("1.Ввести розмір списку.");
        System.out.println("2.Ввести кількість додавань до списку.");
        System.out.println("3.Відсортувати список.");
        System.out.println("4.Вивести список");
        System.out.println("5.Вихід");
        System.out.println("0.Перейти до завдання №1");

        Scanner input = new Scanner(System.in);
        int x=input.nextInt();
        switch (x){
            case 1:
                int N=0;
                System.out.println("Розмір списку:");
                N=input.nextInt();
                System.out.println("Заповніть список "+N+" числами");
                for(int i=0; i<N; i++){
                    int someNum=input.nextInt();
                    myList.add(String.valueOf(someNum));
                }
                MENU2(ex1);
                break;
            case 2:
                int Add=0;
                System.out.println("Введіть кількість додавань.");
                Add=input.nextInt();
                System.out.println("Заповніть список "+Add+" числами" );
                for(int i=0; i<Add; i++) {
                    int someNum = input.nextInt();
                    myList.add(String.valueOf(someNum));
                }
                System.out.println(myList);
                MENU2(ex1);
                break;
            case 3:
                System.out.println("Сортування....");
                Collections.sort(myList);
                MENU2(ex1);
                break;
            case 4:
                System.out.println("Виведення....");
                System.out.println(myList);
                MENU2(ex1);
                break;
            case 5:
                System.out.println("ВИХІД......");
                System.exit(0);
                break;
            case 0:
                MENU1(ex1);
                break;
        }

    }
}