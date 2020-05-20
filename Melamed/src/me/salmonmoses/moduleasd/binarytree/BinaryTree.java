package me.salmonmoses.moduleasd.binarytree;

import java.util.Optional;

public class BinaryTree {
	private Node root = null;

	public void add(int val) {
		if (root == null) {
			root = new Node(val);
		} else {
			root.add(val);
		}
	}

	/* query ::= cmd (' ' cmd)*
	 *  cmd ::= 'l' | 'r' */
	public Optional<Integer> query(String query) {
		if (this.root == null) {
			return Optional.empty();
		}
		Node current = this.root;
		String[] cmds = query.split(" ");
		for (String cmd : cmds) {
			if (cmd.equalsIgnoreCase("l")) {
				if (current.getLeft() != null) {
					current = current.getLeft();
				} else {
					return Optional.empty();
				}
			} else if (cmd.equalsIgnoreCase("r")) {
				if (current.getRight() != null) {
					current = current.getRight();
				} else {
					return Optional.empty();
				}
			}
		}
		return Optional.of(current.getData());
	}

	public Optional<Integer> lcaFor(int a, int b) {
		if (this.root == null) {
			return Optional.empty();
		} else {
			return this.root.lcaFor(a, b);
		}
	}

	private static class Node {
		private final int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public void add(int val) {
			if (val < data) {
				if (this.left == null) {
					this.left = new Node(val);
				} else {
					this.left.add(val);
				}
			} else if (val >= data) {
				if (this.right == null) {
					this.right = new Node(val);
				} else {
					this.right.add(val);
				}
			}
		}

		public Optional<Integer> lcaFor(int a, int b) {
			if (this.getData() == a || this.getData() == b) {
				return Optional.of(this.getData());
			}
			Optional<Integer> leftLca;
			if (this.getLeft() != null) {
				leftLca = this.getLeft().lcaFor(a, b);
			} else {
				leftLca = Optional.empty();
			}
			Optional<Integer> rightLca;
			if (this.getRight() != null) {
				rightLca = this.getRight().lcaFor(a, b);
			} else {
				rightLca = Optional.empty();
			}
			if (leftLca.isPresent() && rightLca.isPresent()) {
				return Optional.of(this.getData());
			} else {
				if (leftLca.isPresent()) {
					return leftLca;
				} else {
					return rightLca;
				}
			}
//			return Optional.empty();
		}

		public int getData() {
			return data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}
}
