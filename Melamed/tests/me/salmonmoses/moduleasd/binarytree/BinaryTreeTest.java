package me.salmonmoses.moduleasd.binarytree;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
	@Test
	void addAddsAndQueryReturnsRightValue() {
		BinaryTree tree = new BinaryTree();
		tree.add(5);
		tree.add(2);
		tree.add(7);
		tree.add(6);
		tree.add(3);
		assertEquals(Optional.of(5), tree.query(""));
		assertEquals(Optional.of(3), tree.query("l r"));
		assertEquals(Optional.of(3), tree.query("l d r"));
		assertEquals(Optional.of(6), tree.query("r l"));
		assertEquals(Optional.empty(), tree.query("l r r"));
	}

	@Test
	void findLca() {
		BinaryTree tree = new BinaryTree();
		tree.add(5);
		tree.add(2);
		tree.add(7);
		tree.add(6);
		tree.add(3);
		assertEquals(Optional.of(5), tree.lcaFor(3, 7));
		assertEquals(Optional.of(5), tree.lcaFor(3, 6));
		assertEquals(Optional.of(5), tree.lcaFor(2, 7));
		assertEquals(Optional.of(5), tree.lcaFor(3, 5));
	}
}