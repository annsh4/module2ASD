package me.salmonmoses.moduleasd.stackvm;

import me.salmonmoses.moduleasd.UnsupportedCommandException;

import java.util.ArrayList;

public class StackVM {
	private Stack stack = new Stack();
	private ArrayList<Integer> maxValues = new ArrayList<>();

//	public void execute(int[][] cmds) throws UnsupportedCommandException {
//		for (int i = 0; i < cmds.length; ++i) {
//			try {
//				executeCommand(cmds[i]);
//			} catch (UnsupportedCommandException e) {
//				throw new UnsupportedCommandException(i);
//			}
//		}
//	}

	public void executeCommand(int[] args) throws UnsupportedCommandException, WrongArgsNumberException {
		switch (args[0]) {
			case 1 -> {
				if(args.length != 2) throw new WrongArgsNumberException();
				stack.push(args[1]);
			}
			case 2 -> {
				if(args.length != 1) throw new WrongArgsNumberException();
				stack.pop();
			}
			case 3 -> {
				if(args.length != 1) throw new WrongArgsNumberException();
				int maxInStack = getMaxInStack();
				if (maxInStack > -1) {
					maxValues.add(maxInStack);
				}
			}
			default -> throw new UnsupportedCommandException();
		}
	}

	public Stack getStack() {
		return stack;
	}

	private int getMaxInStack() {
		int[] array = stack.toArray();
		if (array.length < 1) {
			return -1;
		}
		int max = array[0];
		for (int v : array) {
			if (v > max) {
				max = v;
			}
		}
		return max;
	}

	public ArrayList<Integer> getMaxValues() {
		return maxValues;
	}

	public void clear() {
		stack = new Stack();
		maxValues = new ArrayList<>();
	}
}
