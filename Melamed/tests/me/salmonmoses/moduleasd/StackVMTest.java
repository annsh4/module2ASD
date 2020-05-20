package me.salmonmoses.moduleasd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StackVMTest {
	@Test
	void executeCommandExecutesPushRight() throws UnsupportedCommandException {
		StackVM vm = new StackVM();
		vm.executeCommand(new int[]{1, 5});
		assertEquals(Optional.of(5), vm.getStack().peek());
	}

	@Test
	void executeCommandExecutesPopRight() throws UnsupportedCommandException {
		StackVM vm = new StackVM();
		vm.executeCommand(new int[]{1, 5});
		vm.executeCommand(new int[]{2});
		assertEquals(Optional.empty(), vm.getStack().peek());
	}

	@Test
	void executeCommandExecutesMaxRight() throws UnsupportedCommandException {
		StackVM vm = new StackVM();
		vm.executeCommand(new int[]{1, 5});
		vm.executeCommand(new int[]{1, 7});
		vm.executeCommand(new int[]{1, 6});
		vm.executeCommand(new int[]{3});
		vm.executeCommand(new int[]{1, 9});
		vm.executeCommand(new int[]{3});
		ArrayList<Integer> maxValues = vm.getMaxValues();
		assertEquals(7, maxValues.get(0));
		assertEquals(9, maxValues.get(1));
	}
}