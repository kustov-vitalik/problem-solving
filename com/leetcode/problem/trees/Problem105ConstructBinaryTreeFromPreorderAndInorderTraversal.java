package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;
import java.security.KeyPair;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class Problem105ConstructBinaryTreeFromPreorderAndInorderTraversal {

  public static void main(String[] args) {
    System.out.println(new Solution().buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7}));
    System.out.println(new Solution().buildTree(new int[] {1,2,3}, new int[] {3,2,1}));
    System.out.println(new Solution().buildTree(new int[] {1,2,3}, new int[] {2,3,1}));
    System.out.println(new Solution().buildTree(new int[] {3,1,2,4}, new int[] {1,2,3,4}));
  }

  static class Solution {

    static class Pair {
      TreeNode node;
      int[] range;

      public Pair(TreeNode node, int[] range) {
        this.node = node;
        this.range = range;
      }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      TreeNode node = new TreeNode(preorder[0]);

      if (preorder.length == 1) {
        return node;
      }

      TreeNode ref = node;


      return ref;
    }

    private int indexOf(int key, int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        if (key == nums[i]) {
          return i;
        }
      }
      return -1;
    }
  }

}
