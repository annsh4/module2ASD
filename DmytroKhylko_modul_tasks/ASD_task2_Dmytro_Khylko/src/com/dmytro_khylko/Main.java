// ПП - 11
// Хилько Дмитро
// Варіант 1(17)
// Завдання 2

package com.dmytro_khylko;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	BinaryTree bt = new BinaryTree();
		System.out.println("Input number of nodes");
		int numberOfNodes = getNumber();
		System.out.println("Input string of nodes values");
		for(int i = 0; i < numberOfNodes; i++){
			bt.insert(getNumber());
		}
		System.out.println("Input nodes value to find theirs LCA");
		System.out.println(bt.findLCA(getNumber(), getNumber()));
		System.out.println("Your tree");
		bt.printInOrder();
    }

	public static int getNumber(){
		int number = Integer.MIN_VALUE;
		boolean error;
		do {
			try {
				number = sc.nextInt();
				error = false;
			} catch (InputMismatchException e) {
				error = true;
				System.out.println("Input error");
				sc.next();
			}
		} while (error);
		return number;
	}
}
