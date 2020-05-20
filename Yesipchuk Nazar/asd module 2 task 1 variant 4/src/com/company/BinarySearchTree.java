package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinarySearchTree<T> {
    public static class Option<S> {
        public final boolean isEmpty;
        public final S value;
        public static final Option empty = new Option(null, true);

        public Option(S value, boolean isEmpty) {
            this.value = value;
            this.isEmpty = isEmpty;
        }

        public Option(S value) {
            this(value, false);
        }
    }
    public interface Searcher<T> {
        boolean accepts(T value);
    }
    public T value;
    public BinarySearchTree<T> left, right, parent;

    public BinarySearchTree(T value, BinarySearchTree parent) {
        this.value = value;
        this.parent = parent;
    }
    public void add(T value) {
        if (this.value == null) {
            this.value = value;
            return;
        }
        if (left == null) {
            left = new BinarySearchTree<>(value, this);
            return;
        }
        if (right == null) {
            right = new BinarySearchTree<>(value, this);
            return;
        }
        if (left.getNodesCount(false) <= right.getNodesCount(false))
            left.add(value);
        else
            right.add(value);
    }
    public Option<BinarySearchTree<T>> delete(T value) {
        if (this.value.equals(value)) {
            delete(left, right);
            if (left != null)
                return new Option<>(left);
            if (right != null)
                return new Option<>(right);
            return new Option<>(null);
        }
        Option<BinarySearchTree<T>> newTree;

        if (left != null) {
            newTree = left.delete(value);
            if (!newTree.isEmpty) {
                left = newTree.value;
                return Option.empty;
            }
        } else {
            if (right != null) {
                newTree = right.delete(value);
                if (!newTree.isEmpty) {
                    right = newTree.value;
                    return Option.empty;
                }
            }
            return Option.empty;
        }

        if (right != null) {
            newTree = right.delete(value);
            if (!newTree.isEmpty) {
                right = newTree.value;
                return Option.empty;
            }
        }
        return Option.empty;
    }

    public void delete(BinarySearchTree<T> newLeft, BinarySearchTree<T> newRight) {
        if (left != null) {
            left.delete(null, right);
        } else if (right != null) {
            right.delete(left, null);
        }
        if (newLeft != null)
            left = newLeft;
        if (newRight != null)
            right = newRight;
    }

    public int getNodesCount(boolean root) {
        int n = 0;
        if (root)
            n = 1;
        if (left != null)
            n += left.getNodesCount(false) + 1;
        if (right != null)
            n += right.getNodesCount(false) + 1;
        return n;
    }

    public List<BinarySearchTree<T>> getNodes(boolean root) {
        List<BinarySearchTree<T>> list = new ArrayList<>();
        if (root)
            list.add(this);
        list.add(left);
        list.add(right);
        if (left != null) {
            list.addAll(left.getNodes(false));
        }
        if (right != null) {
            list.addAll(right.getNodes(false));
        }
        return list;
    }

    public void forEachNode(Consumer<BinarySearchTree<T>> consumer) {
        List<BinarySearchTree<T>> nodes = getNodes(true);
        for (BinarySearchTree<T> node : nodes)
            consumer.accept(node);
    }

    public BinarySearchTree<T> find(Searcher<T> search) {
        if (search.accepts(value))
            return this;
        BinarySearchTree<T> res = null;

        if (left != null)
            res = left.find(search);
        if (res != null)
            return res;

        if (right != null)
            res = right.find(search);
        return res;
    }
    public List<BinarySearchTree<T>> getAncestors() {
        List<BinarySearchTree<T>> anc = new ArrayList<>();
        if (parent == null)
            return anc;
        anc.add(parent);
        anc.addAll(parent.getAncestors());
        return anc;
    }

    public static BinarySearchTree<?> LCA (BinarySearchTree<?> i, BinarySearchTree<?> o) {
        List<? extends BinarySearchTree<?>> iAnc = i.getAncestors();
        List<? extends BinarySearchTree<?>> oAnc = o.getAncestors();

        for (BinarySearchTree<?> iAncestor : iAnc)
            for (BinarySearchTree<?> oAncestor : oAnc)
                if (iAnc == oAnc)
                    return iAncestor;
        return null;
    }
}