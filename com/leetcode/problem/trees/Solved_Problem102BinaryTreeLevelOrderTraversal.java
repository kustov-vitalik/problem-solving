package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solved_Problem102BinaryTreeLevelOrderTraversal {

  public static void main(String[] args) {

  }

  static class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) {
        return new ArrayList<>();
      }

      List<List<Integer>> output = new ArrayList<>();

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.poll();
          nums.add(node.val);

          if (node.left != null) {
            queue.offer(node.left);
          }
          if (node.right != null) {
            queue.offer(node.right);
          }
        }
        output.add(nums);
      }

      return output;
    }
  }

}
