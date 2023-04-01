package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;

public class Solved_Problem101SymmetricTree {

  public static void main(String[] args) {
    System.out.println(new Solution().isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3))))); // true
    System.out.println(new Solution().isSymmetric(new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, new TreeNode(3), null)))); // true
  }

  static class Solution {

    public boolean isSymmetric(TreeNode root) {
      if (root == null) {
        return true;
      }

      inOrder(root.left);


      return treesAreEq(root.right, root.left);
    }

    private void inOrder(TreeNode node) {
      if (node == null) {
        return;
      }

      inOrder(node.left);
      inOrder(node.right);

      TreeNode left = node.left;
      node.left = node.right;
      node.right = left;

    }

    private boolean treesAreEq(TreeNode node1, TreeNode node2) {

      if (node1 == null && node2 != null) {
        return false;
      }

      if (node1 != null && node2 == null) {
        return false;
      }

      if (node1 == null && node2 == null) {
        return true;
      }

      if (node1.val != node2.val) {
        return false;
      }

      return treesAreEq(node1.left, node2.left) && treesAreEq(node1.right, node2.right);
    }
  }

}
