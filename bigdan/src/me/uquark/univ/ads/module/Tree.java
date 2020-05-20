package me.uquark.univ.ads.module;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

// Код из моей же 7-й лабы, слегка допиленный

public class Tree<T> {
    public static class Optional<K> {
        public final boolean isEmpty;
        public final K value;
        public static final Optional empty = new Optional(null, true);

        public Optional(K value, boolean isEmpty) {
            this.value = value;
            this.isEmpty = isEmpty;
        }

        public Optional(K value) {
            this(value, false);
        }
    }

    public interface Searcher<T> {
        boolean accepts(T value);
    }

    public T value;
    public Tree<T> left, right, parent;

    public Tree(T value, Tree parent) {
        this.value = value;
        this.parent = parent;
    }

    public void add(T value) {
        if (this.value == null) {
            this.value = value;
            return;
        }

        if (left == null) {
            left = new Tree<>(value, this);
            return;
        }
        if (right == null) {
            right = new Tree<>(value, this);
            return;
        }

        if (left.getNodesCount(false) <= right.getNodesCount(false))
            left.add(value);
        else
            right.add(value);
    }

    public static Tree fromArray(Object... array) {
        if (array.length == 0)
            return null;
        Tree tree = new Tree(array[0], null);
        for (int i=1; i < array.length; i++)
            tree.add(array[i]);
        return tree;
    }

    public Optional<Tree<T>> delete(T value) {
        if (this.value.equals(value)) {
            delete(left, right);
            if (left != null)
                return new Optional<>(left);
            if (right != null)
                return new Optional<>(right);
            return new Optional<>(null);
        }

        Optional<Tree<T>> newTree;

        if (left != null) {
            newTree = left.delete(value);
            if (!newTree.isEmpty) {
                left = newTree.value;
                return Optional.empty;
            }
        } else {
            if (right != null) {
                newTree = right.delete(value);
                if (!newTree.isEmpty) {
                    right = newTree.value;
                    return Optional.empty;
                }
            }
            return Optional.empty;
        }

        if (right != null) {
            newTree = right.delete(value);
            if (!newTree.isEmpty) {
                right = newTree.value;
                return Optional.empty;
            }
        }

        return Optional.empty;
    }

    public void delete(Tree<T> newLeft, Tree<T> newRight) {
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
        int nodes = 0;
        if (root)
            nodes = 1;
        if (left != null)
            nodes += left.getNodesCount(false) + 1;
        if (right != null)
            nodes += right.getNodesCount(false) + 1;
        return nodes;
    }

    public List<Tree<T>> getNodes(boolean root) {
        List<Tree<T>> list = new ArrayList<>();
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

    public void forEachNode(Consumer<Tree<T>> consumer) {
        List<Tree<T>> nodes = getNodes(true);
        for (Tree<T> node : nodes)
            consumer.accept(node);
    }

    public Tree<T> find(Searcher<T> searcher) {
        if (searcher.accepts(value))
            return this;
        Tree<T> result = null;

        if (left != null)
            result = left.find(searcher);
        if (result != null)
            return result;

        if (right != null)
            result = right.find(searcher);
        return result;
    }

    public List<Tree<T>> findAll(Searcher<T> searcher) {
        List<Tree<T>> result = new ArrayList<>();

        if (searcher.accepts(value))
            result.add(this);

        if (left != null)
            result.addAll(left.findAll(searcher));
        if (right != null)
            result.addAll(right.findAll(searcher));

        return result;
    }

    public List<Tree<T>> getAncestors() {
        List<Tree<T>> ancestors = new ArrayList<>();
        if (parent == null)
            return ancestors;
        ancestors.add(parent);
        ancestors.addAll(parent.getAncestors());
        return ancestors;
    }

    public static Tree<?> lca(Tree<?> a, Tree<?> b) {
        List<? extends Tree<?>> aAncestors = a.getAncestors();
        List<? extends Tree<?>> bAncestors = b.getAncestors();

        for (Tree<?> aAncestor : aAncestors)
            for (Tree<?> bAncestor : bAncestors)
                if (aAncestor == bAncestor)
                    return aAncestor;
        return null;
    }
}
