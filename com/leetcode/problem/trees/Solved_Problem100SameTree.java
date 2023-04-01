package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;

public class Solved_Problem100SameTree {

  class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      return treesAreEq(p, q);
    }

    public boolean treesAreEq(TreeNode node1, TreeNode node2) {

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
