package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;

public class Solved_Problem99RecoverBinarySearchTree {

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
    new Solution().recoverTree(tree);
    System.out.println(tree); // [3,1,0,0,2] (swap "1" and "3")
  }

  static class Solution {

    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {

      inOrderTraverse(root);

      var val = first.val;
      first.val = second.val;
      second.val = val;

    }

    private void inOrderTraverse(TreeNode node) {
      if (node == null) {
        return;
      }

      inOrderTraverse(node.left);

      if (prev != null && prev.val > node.val) {
        if (first == null) {
          first = prev;
        } else {
          second = node;
        }
      }

      prev = node;
      inOrderTraverse(node.right);
    }
  }

}
