package me.salmonmoses.moduleasd;

import java.util.ArrayList;

public class StackVM {
	private final Stack stack = new Stack();
	private final ArrayList<Integer> maxValues = new ArrayList<>();

//	public void execute(int[][] cmds) throws UnsupportedCommandException {
//		for (int i = 0; i < cmds.length; ++i) {
//			try {
//				executeCommand(cmds[i]);
//			} catch (UnsupportedCommandException e) {
//				throw new UnsupportedCommandException(i);
//			}
//		}
//	}

	public void executeCommand(int[] args) throws UnsupportedCommandException {
		switch (args[0]) {
			case 1 -> stack.push(args[1]);
			case 2 -> stack.pop();
			case 3 -> maxValues.add(getMaxInStack());
			default -> throw new UnsupportedCommandException();
		}
	}

	public Stack getStack() {
		return stack;
	}

	private int getMaxInStack() {
		int[] array = stack.toArray();
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
}
