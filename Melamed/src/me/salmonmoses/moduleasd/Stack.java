package me.salmonmoses.moduleasd;

import java.util.ArrayList;
import java.util.Optional;

public class Stack {
	private Node head;

	public Stack() {
		this.head = null;
	}

	public Stack(int val) {
		this.head = new Node(val);
	}

	public void push(int val) {
		this.head = new Node(val, head);
	}

	public Optional<Integer> pop() {
		if(this.head == null) return Optional.empty();
		int poppedVal = this.head.data;
		this.head = this.head.next;
		return Optional.of(poppedVal);
	}

	public Optional<Integer> peek() {
		if(this.head == null) return Optional.empty();
		return Optional.of(this.head.data);
	}

	public int[] toArray() {
		Stack anotherStack = new Stack();
		ArrayList<Integer> list = new ArrayList<>();
		while(this.peek().isPresent()) {
			anotherStack.push(this.pop().get());
		}
		while(anotherStack.peek().isPresent()) {
			int val = anotherStack.pop().get();
			list.add(val);
			this.push(val);
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

	private static class Node {
		private final int data;
		private final Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
}
