package me.salmonmoses.moduleasd;

import java.util.Scanner;

public class Prompts {
	private static Scanner input = new Scanner(System.in);

	public static int promptInt(String prompt) {
		System.out.print(prompt);
		String in = input.nextLine();
		return Integer.parseInt(in);
	}

	public static int promptInt(String prompt, int from) throws AnswerOutOfBoundsException {
		int input = promptInt(prompt);
		if(input < from) {
			throw new AnswerOutOfBoundsException();
		}
		return input;
	}

	public static int promptInt(String prompt, int from, int to) throws AnswerOutOfBoundsException {
		int input = promptInt(prompt);
		if(input < from || input > to) {
			throw new AnswerOutOfBoundsException();
		}
		return input;
	}

	public static boolean promptBoolean(String prompt) {
		System.out.print(prompt);
		String answer = input.next();
		return answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes");
	}

	public static String promptLine(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}
}
