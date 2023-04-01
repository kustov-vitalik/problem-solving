package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;

public class Solved_Problem98ValidateBinarySearchTree {

  public static void main(String[] args) {
    System.out.println(new Solution().isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3)))); // true
    System.out.println(new Solution().isValidBST(new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6))))); // false
    System.out.println(new Solution().isValidBST(new TreeNode(5, new TreeNode(2, new TreeNode(1), new TreeNode(6)), new TreeNode(10)))); // false
    System.out.println(new Solution().isValidBST(new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(5, new TreeNode(4), new TreeNode(6))))); // false
  }

  static class Solution {
    public boolean isValidBST(TreeNode root) {
      return isValidNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidNode(TreeNode root, long min, long max) {
      if (root == null) {
        return true;
      }

      if (root.val >= max) {
        return false;
      }

      if (root.val <= min) {
        return false;
      }

      if (root.left == null && root.right == null) {
        return true;
      }

      if (root.left != null && root.left.val >= root.val) {
        return false;
      }

      if (root.right != null && root.val >= root.right.val) {
        return false;
      }

      boolean leftValid = root.left == null || isValidNode(root.left, min, root.val);
      boolean rightValid = root.right == null || isValidNode(root.right, root.val, max);

      return leftValid && rightValid;
    }
  }

}
