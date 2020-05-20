package me.salmonmoses.moduleasd.binarytree;

import me.salmonmoses.moduleasd.AnswerOutOfBoundsException;
import me.salmonmoses.moduleasd.Prompts;
import me.salmonmoses.moduleasd.Task;
import me.salmonmoses.moduleasd.UnsupportedCommandException;
import me.salmonmoses.moduleasd.stackvm.StackVM;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 implements Task {
	private Scanner input;

	public Task2(Scanner input) {
		this.input = input;
	}

	@Override
	public String title() {
		return "Binary Tree Common Ancestor";
	}

	@Override
	public void solve() {
		int n;
		BinaryTree tree = new BinaryTree();
		try {
			n = Prompts.promptInt("How many elements must be in the binary tree? ", 3);
		} catch (AnswerOutOfBoundsException e) {
			System.out.println("Sorry, there must be at least 3 elements");
			return;
		} catch (NumberFormatException e) {
			System.out.println("Please, write literally 1 number");
			return;
		}
		System.out.println("Now, please, enter elements of the binary tree (they will be added in the order of inputting): ");
		for(int i = 0; i < n; ++i) {
			tree.add(Prompts.promptInt("> "));
		}
		System.out.println("Now enter n1 and n2 to search their LCA: ");
		int n1 = Prompts.promptInt("n1 = ");
		int n2 = Prompts.promptInt("n2 = ");
	}
}
