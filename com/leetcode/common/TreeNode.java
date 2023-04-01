package com.leetcode.common;

public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  public TreeNode(int x, TreeNode left, TreeNode right) {
    this(x);
    this.left = left;
    this.right = right;
  }

  @Override
  public String toString() {
    if (left == null && right == null) {
      return String.valueOf(val);
    }
    return "{" +val +
        "," + left +
        "," + right +
        '}';
  }
}
