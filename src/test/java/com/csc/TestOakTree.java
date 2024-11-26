package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestOakTree {

    private OakTree.BinaryTree tree;

    @BeforeEach
    void setUp() {
        OakTree.Squirrel squirrel1 = new OakTree.Squirrel("Squirrel 1");
        tree = new OakTree.BinaryTree(squirrel1);
    }

    @Test
    void testAddNodeToLeft() {
        OakTree.Squirrel squirrel2 = new OakTree.Squirrel("Squirrel 2");
        OakTree.BinaryTreeNode node2 = new OakTree.BinaryTreeNode(squirrel2);

        tree.addNode(tree.getRoot(), node2, true);
        assertEquals(squirrel2, tree.getRoot().getLeft().getSquirrel());
    }

    @Test
    void testAddNodeToRight() {
        OakTree.Squirrel squirrel3 = new OakTree.Squirrel("Squirrel 3");
        OakTree.BinaryTreeNode node3 = new OakTree.BinaryTreeNode(squirrel3);

        tree.addNode(tree.getRoot(), node3, false);
        assertEquals(squirrel3, tree.getRoot().getRight().getSquirrel());
    }

    @Test
    void testTraverseTree() {
        OakTree.Squirrel squirrel2 = new OakTree.Squirrel("Squirrel 2");
        OakTree.Squirrel squirrel3 = new OakTree.Squirrel("Squirrel 3");
        OakTree.BinaryTreeNode node2 = new OakTree.BinaryTreeNode(squirrel2);
        OakTree.BinaryTreeNode node3 = new OakTree.BinaryTreeNode(squirrel3);

        tree.addNode(tree.getRoot(), node2, true);
        tree.addNode(tree.getRoot(), node3, false);

        StringBuilder sb = new StringBuilder();
        tree.traverseTree(tree.getRoot());
        assertTrue(sb.toString().contains("Squirrel 1"));
        assertTrue(sb.toString().contains("Squirrel 2"));
        assertTrue(sb.toString().contains("Squirrel 3"));
    }
}
