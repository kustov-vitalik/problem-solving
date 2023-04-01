package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solved_Problem95UniqueBinarySearchTrees2 {

  public static void main(String[] args) {
    System.out.println(new Solution().generateTrees(1));
    System.out.println(new Solution().generateTrees(2));
    System.out.println(new Solution().generateTrees(3));
  }

  static class Solution {

    static class CustomTreeNode extends TreeNode {

      public CustomTreeNode(int x) {
        super(x);
      }

      public CustomTreeNode(int x, TreeNode left, TreeNode right) {
        super(x, left, right);
      }

      @Override
      public int hashCode() {
        return super.hashCode();
      }

      @Override
      public boolean equals(Object obj) {
        if (this == obj) {
          return true;
        }

        CustomTreeNode node = (CustomTreeNode) obj;

        return treesAreEq(this, node);
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

    public List<TreeNode> generateTrees(int n) {

      List<int[]> permutations = new ArrayList<>();
      int[] nums = new int[n];
      for (int i = 0; i < nums.length; i++) {
        nums[i] = i + 1;
      }
      populatePermutations(permutations, 0, nums);

      List<TreeNode> treeNodeList = new ArrayList<>();
      permutations.forEach(permutation -> {
        TreeNode treeNode = buildTree(permutation);
        if (!treeNodeList.contains(treeNode)) {
          treeNodeList.add(treeNode);
        }
      });

      return treeNodeList;
    }

    private void populatePermutations(List<int[]> permutations, int start, int[] nums) {

      if (start == nums.length) {
        permutations.add(Arrays.copyOf(nums, nums.length));
      }

      for (int i = start; i < nums.length; i++) {
        swap(nums, start, i);
        populatePermutations(permutations, start + 1, nums);
        swap(nums, start, i);
      }
    }

    private void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }

    private TreeNode buildTree(int[] nums) {

      TreeNode root = null;
      for (int i = 0; i < nums.length; i++) {
        if (root == null) {
          root = new CustomTreeNode(nums[i]);
        } else {
          append(root, new CustomTreeNode(nums[i]));
        }
      }

      return root;
    }

    private void append(TreeNode root, TreeNode node) {
      if (root.val > node.val) {
        if (root.left == null) {
          root.left = node;
        } else {
          append(root.left, node);
        }
      } else {
        if (root.right == null) {
          root.right = node;
        } else {
          append(root.right, node);
        }
      }
    }
  }

}
