package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;

public class Solved_Problem104MaximumDepthOfBinaryTree {

  static class Solution {

    int maxDepth;
    public int maxDepth(TreeNode root) {
      maxDepth = Integer.MIN_VALUE;
      traverse(root, 0);
      return maxDepth;
    }

    private void traverse(TreeNode node, int currentDepth) {

      maxDepth = Math.max(maxDepth, currentDepth);

      if (node == null) {
        return;
      }

      traverse(node.left, currentDepth+1);
      traverse(node.right, currentDepth+1);
    }
  }

}
