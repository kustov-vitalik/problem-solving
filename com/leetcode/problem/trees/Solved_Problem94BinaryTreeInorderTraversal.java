package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solved_Problem94BinaryTreeInorderTraversal {

  public static void main(String[] args) {
    System.out.println(new Solution().inorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)))); // [1,3,2]
  }

  static class Solution {
    List<Integer> output;
    public List<Integer> inorderTraversal(TreeNode root) {
      output = new ArrayList<>();
      if (root == null) {
        return output;
      }

      traverse(root);

      return output;
    }

    private void traverse(TreeNode root) {
      if (root == null) {
        return;
      }
      traverse(root.left);
      output.add(root.val);
      traverse(root.right);
    }
  }

}
