package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solved_Problem144BinaryTreePreorderTraversal {

  static class Solution {

    List<Integer> ints;
    public List<Integer> preorderTraversal(TreeNode root) {
      ints = new ArrayList<>();

      preOrder(root);

      return ints;
    }

    private void preOrder(TreeNode root) {
      if (root == null) {
        return;
      }

      ints.add(root.val);
      preOrder(root.left);
      preOrder(root.right);
    }
  }

}
