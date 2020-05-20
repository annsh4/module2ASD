package me.salmonmoses.moduleasd.stack;

import me.salmonmoses.moduleasd.stackvm.Stack;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

	@Test
	void pushActuallyDoesPushToStack() {
		Stack stack = new Stack(5);
		assertEquals(Optional.of(5), stack.peek());
		stack.push(6);
		assertEquals(Optional.of(6), stack.peek());
	}

	@Test
	void popReturnsLastValueAndPopsItFromStack() {
		Stack stack = new Stack(5);
		stack.push(6);
		assertEquals(Optional.of(6), stack.pop());
		assertEquals(Optional.of(5), stack.peek());
		assertEquals(Optional.of(5), stack.pop());
		assertEquals(Optional.empty(), stack.peek());
		assertEquals(Optional.empty(), stack.pop());
		assertEquals(Optional.empty(), stack.pop());
	}

	@Test
	void peekJustReturnsLastValueWithoutChangingStack() {
		Stack stack = new Stack(5);
		assertEquals(Optional.of(5), stack.peek());
		assertEquals(Optional.of(5), stack.peek());
		stack.pop();
		assertEquals(Optional.empty(), stack.peek());
	}

	@Test
	void toArrayConvertsStackToIntArray() {
		Stack stack = new Stack(5);
		assertArrayEquals(new int[] {5}, stack.toArray());
		assertEquals(Optional.of(5), stack.peek());
		stack.push(6);
		stack.push(7);
		assertArrayEquals(new int[] {5, 6, 7}, stack.toArray());
		assertEquals(Optional.of(7), stack.peek());
	}
}