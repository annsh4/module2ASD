package Module2;


import java.util.Scanner;

public class main {
    public static int a=0;
    public static list[] list = new list[4];
    private static int i;
    public static int Global(){
        a++;
        return a;
    }
    public static void RandomSt(int i) {
        int a = 1;
        while (a <= 20) {
            list[i].add(Global(), +a);
            a++;
        }
        list[i].print();
    }
    public static void menu(){
        System.out.println("1-стек 2-стек; 3-стек 4-start");
        Scanner sca =new Scanner(System.in);
        int chose=0;
        chose = sca.nextInt();
        i=chose-1;
        switch (chose) {
            case 1:
                menuStack();
                break;
            case 2:
                menuStack();
                break;
            case 3:
                menuStack();
                break;
            case 4:
               Shit();
            default:
                menu();

        }
        menuStack();
    }
    public static void Endd(){
        System.out.println("отримати різне значення в усіх трьох стеках видаляти неможливо ");
        System.exit(0);
    }
    public static void menuStack() {
        System.out.println("1-друкування списку. 2-додавання елементів до списку;3-вилучення елементів зі списку 4-Exit");
        Scanner sca = new Scanner(System.in);
        int chose = 0;
        chose = sca.nextInt();
        while (true) {
            switch (chose) {
                case 1:
                    PrintStack();
                    break;
                case 2:
                    KeyboardInput();//PlayerDefault();
                    break;
                case 3:
                    Delete();
                    break;
                case 4:
                    menu();
                default:
                    menu();

            }
        }
    }

    public static void Shit(){
        for(int i=0;i<3;i++){
            int z=+1;
            System.out.println("Steck"+z);
            list[i].print();
        }
        boolean ff=true;
        while(ff !=false){
            for(int i=0;i<3;i++){
                list[i].Endless();
            }
            int i=0;
            if(list[i].getSum() > list[i+1].getSum()||list[i].getSum() > list[i+2].getSum()){
              System.out.println("1");
              list[i].remove();
                if(list[i].isError()==false){
                  Endd();
                }
                }
            if(list[i+1].getSum() > list[i].getSum() || list[i+1].getSum() > list[i+2].getSum()){
                System.out.println("2");
                list[i+1].remove();
                if(list[i+1].isError()==false){
                    Endd();
                }
            }
            if(list[i+2].getSum() > list[i].getSum() || list[i+2].getSum() > list[i+1].getSum()){
                System.out.println("3");
                list[i+2].remove();
                if(list[i+2].isError()==false){
                    Endd();
                }
            }
            if(list[i].getSum() == list[i+1].getSum()&& list[i].getSum() == list[i+2].getSum()){
                for(int S=0;S<3;S++){
                    int z=+1;
                    System.out.println("Steck"+z);
                    list[S].print();
                }
                ff=false;
                break;
            }

        }
    }

    public static void PrintStack(){

        list[i].print();
        menuStack();
    }

    public static int getNum() {
        int b=0;
        try {
            Scanner sca =new Scanner(System.in);
            b=sca.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Ви ввели невірні дані!");
            menu();
        }
        return b;
    }

    public static void KeyboardInput(){
        int b;
        System.out.println("Enter number");
        b=getNum();
        list[i].add(Global(),b);
        menuStack();
    }
    public static void Delete(){
        list[i].remove();
        menuStack();
    }
    public static void main(String[] args) {
        for(int i=0;i<3;i++)
        {
            list[i] = new list();
        }
        list[0].add(1);
        list[0].add(1);
        list[0].add(1);
        list[0].add(2);
        list[0].add(3);
        list[0].print();
        list[1].add(2);
        list[1].add(3);
        list[1].add(4);
        list[1].print();
        list[2].add(1);
        list[2].add(4);
        list[2].add(1);
        list[2].add(1);
        list[2].print();
        System.out.println("Option 2 exercise 1");
        menu();
    }
}


