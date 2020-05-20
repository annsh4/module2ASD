package com.company;
import java.util.*;
import  java.util.Arrays;

class GFG {

    public static int maxSum(int stack1[], int stack2[],
                             int stack3[], int n1, int n2,
                             int n3)
    {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i=0; i < n1; i++)
            sum1 += stack1[i];

        for (int i=0; i < n2; i++)
            sum2 += stack2[i];

        for (int i=0; i < n3; i++)
            sum3 += stack3[i];

        int top1 =0, top2 = 0, top3 = 0;
        int ans = 0;
        while (true)
        {
            if (top1 == n1 || top2 == n2 || top3 == n3)
                return 0;

            if (sum1 == sum2 && sum2 == sum3)
                return sum1;

            if (sum1 >= sum2 && sum1 >= sum3)
                sum1 -= stack1[top1++];
            else if (sum2 >= sum3 && sum2 >= sum3)
                sum2 -= stack2[top2++];
            else if (sum3 >= sum2 && sum3 >= sum1)
                sum3 -= stack3[top3++];
        }
    }


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Уведіть розмір першого стеку :");
        int st1 = in.nextInt();
        System.out.println("Уведіть розмір другого стеку :");
        int st2 = in.nextInt();
        System.out.println("Уведіть розмір третого стеку :");
        int st3 = in.nextInt();

        int[] stack1 = new int[st1];
        int[] stack2 = new int[st2];
        int[] stack3 = new int[st3];

        System.out.println("Уведіть елементи першого стеку :");
        for (int i = 0 ; i < st1 ; i++){
            int elem = in.nextInt();
            Arrays.fill(stack1,elem);
        }
        System.out.println("Уведіть елементи другого стеку :");
        for (int i = 0 ; i < st2 ; i++){
            int elem = in.nextInt();
            Arrays.fill(stack2,elem);
        }
        System.out.println("Уведіть елементи третого стеку :");
        for (int i = 0 ; i < st3 ; i++){
            int elem = in.nextInt();
            Arrays.fill(stack3,elem);
        }

        int n1 = stack1.length;
        int n2 = stack2.length;
        int n3 = stack3.length;

        System.out.println(maxSum(stack1, stack2,
                stack3, n1, n2, n3));
    }
}