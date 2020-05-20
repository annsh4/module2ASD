package me.uquark.univ.ads.module;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    private static class IntegerStack {
        private List<Integer> values = new ArrayList<>();

        public void push(int value) {
            values.add(value);
        }

        public int top() {
            return values.get(count() - 1);
        }

        public int pop() {
            if (count() == 0)
                return 0;
            int value = top();
            values.remove(count() - 1);
            return value;
        }

        public int getMax() {
            if (count() == 0)
                return 0;
            int max = Integer.MIN_VALUE;
            for (Integer value : values)
                if (value > max)
                    max = value;
            return max;
        }

        public void print() {
            for (Integer value : values)
                System.out.printf("%d ", value);
            System.out.println();
        }

        public int count() {
            return values.size();
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            IntegerStack stack = new IntegerStack();
            System.out.print("Количество операций ");
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.print("Опкод: ");
                int command = scanner.nextInt();
                switch (command) {
                    case 1:
                        int value = scanner.nextInt();
                        stack.push(value);
                        break;
                    case 2:
                        stack.pop();
                        break;
                    case 3:
                        System.out.println(stack.getMax());
                        break;
                }
            }
            System.out.println("Остаток в стеке: ");
            stack.print();
        } catch (InputMismatchException e) {
            System.out.println("Неверный формат входных данных");
        } catch (Exception e) {
            System.out.println("Приключилася дурня");
            e.printStackTrace();
        }
    }
}
