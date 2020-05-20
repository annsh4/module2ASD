/*
 * ПП-11
 * Меламед Михайло
 * Варіант 1 (11)
 */

package me.salmonmoses.moduleasd;

import me.salmonmoses.moduleasd.stackvm.Task1;

import java.util.Scanner;

public class Main {
    private final static Scanner input = new Scanner(System.in);
    private Task[] tasks;

    public Main() {
        tasks = new Task[1];
        tasks[0] = new Task1(input);
//        tasks[1] = new Task2(input);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        System.out.println("Enter task number(1-2): ");
        showMainMenu();
        mainLoop();
    }

    private void showMainMenu() {
        System.out.println("Available tasks: ");
        for(int i = 0; i < tasks.length; ++i) {
            System.out.println((i + 1) + ". " + tasks[i].title());
        }
    }

    private void mainLoop() {
        int selection;
        try (input) {
            do {
                selection = Prompts.promptInt("> ");
                try {
                    tasks[selection - 1].solve();
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            } while (true);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input! Abort");
        }
    }
}
