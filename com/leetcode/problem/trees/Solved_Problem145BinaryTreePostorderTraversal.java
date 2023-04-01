package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solved_Problem145BinaryTreePostorderTraversal {
  static class Solution {

    List<Integer> ints;
    public List<Integer> postorderTraversal(TreeNode root) {
      ints = new ArrayList<>();

      postOrder(root);

      return ints;
    }

    private void postOrder(TreeNode root) {
      if (root == null) {
        return;
      }

      postOrder(root.left);
      postOrder(root.right);
      ints.add(root.val);
    }
  }
}
