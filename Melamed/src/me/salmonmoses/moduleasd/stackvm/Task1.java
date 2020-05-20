package me.salmonmoses.moduleasd.stackvm;

import me.salmonmoses.moduleasd.AnswerOutOfBoundsException;
import me.salmonmoses.moduleasd.Prompts;
import me.salmonmoses.moduleasd.Task;
import me.salmonmoses.moduleasd.UnsupportedCommandException;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 implements Task {
	private Scanner input;
	private StackVM vm = new StackVM();

	public Task1(Scanner input) {
		this.input = input;
	}

	@Override
	public String title() {
		return "Integer Stack VM";
	}

	@Override
	public void solve() {
		int n;
		try {
			n = Prompts.promptInt("How many operations do you want to execute? ", 0);
		} catch (AnswerOutOfBoundsException | NumberFormatException e) {
			System.out.println("Sorry, only positive integer values are allowed");
			return;
		}
		System.out.println("Available commands and their usage:");
		System.out.println("1 [x] - push x to stack");
		System.out.println("2 - pop value from stack");
		System.out.println("3 - get max value from stack and add it to the max values list");
		System.out.println("Enter " + n + " commands. Commands with errors don't count");
		for(int i = 0; i < n; ++i) {
			String line = Prompts.promptLine(">>>");
			try {
				String[] strArgs = line.split(" ");
				int[] args = Arrays.stream(strArgs).mapToInt(Integer::valueOf).toArray();
				vm.executeCommand(args);
			} catch (NumberFormatException e) {
				System.out.println("Syntax error at line " + (i + 1) + ": expected number");
				--i;
			} catch (UnsupportedCommandException e) {
				System.out.println("Syntax error at line " + (i + 1) + ": unknown command");
				--i;
			}
		}
		System.out.println("VM execution results: ");
		System.out.println("Stack = " + Arrays.toString(vm.getStack().toArray()));
		System.out.println("Max values = " + vm.getMaxValues().toString());
		vm.clear();
	}
}
