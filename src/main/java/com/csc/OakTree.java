package com.csc;

public class OakTree {

public static class Squirrel {
    private String name;

    public Squirrel(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    @Override
    public String toString() {
      return "Squirrel{" + "name='" + name + '\'' + '}';
    }
}

public static class BinaryTreeNode {
    private Squirrel squirrel;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(Squirrel squirrel) {
      this.squirrel = squirrel;
      this.left = null;
      this.right = null;
    }

    public Squirrel getSquirrel() {
      return squirrel;
    }

    public BinaryTreeNode getLeft() {
      return left;
    }

    public void setLeft(BinaryTreeNode left) {
      this.left = left;
    }

    public BinaryTreeNode getRight() {
      return right;
    }

    public void setRight(BinaryTreeNode right) {
      this.right = right;
    }
}

public static class BinaryTree {
  private BinaryTreeNode root;

  public BinaryTree(Squirrel rootSquirrel) {
    this.root = new BinaryTreeNode(rootSquirrel);
  }

  public BinaryTreeNode getRoot() {
    return root;
  }

  public void addNode(BinaryTreeNode parent, BinaryTreeNode newNode, boolean isLeft) {
    if (isLeft) {
      parent.setLeft(newNode);
    } else {
      parent.setRight(newNode);
    }
  }

  public void traverseTree(BinaryTreeNode node) {
    if (node != null) {
      traverseTree(node.getLeft());
      System.out.println(node.getSquirrel());
      traverseTree(node.getRight());
    }
  }
}

public static void main(String[] args) {
  Squirrel squirrel1 = new Squirrel("Squirrel 1");
  Squirrel squirrel2 = new Squirrel("Squirrel 2");
  Squirrel squirrel3 = new Squirrel("Squirrel 3");
  Squirrel squirrel4 = new Squirrel("Squirrel 4");

  BinaryTree tree = new BinaryTree(squirrel1);

  BinaryTreeNode node2 = new BinaryTreeNode(squirrel2);
  BinaryTreeNode node3 = new BinaryTreeNode(squirrel3);
  BinaryTreeNode node4 = new BinaryTreeNode(squirrel4);

  tree.addNode(tree.getRoot(), node2, true);  
  tree.addNode(tree.getRoot(), node3, false); 
  tree.addNode(node2, node4, true);        

  System.out.println("Tree traversal:");
  tree.traverseTree(tree.getRoot());
}

}
