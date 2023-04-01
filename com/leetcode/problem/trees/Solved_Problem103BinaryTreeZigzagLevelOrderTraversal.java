package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solved_Problem103BinaryTreeZigzagLevelOrderTraversal {

  public static void main(String[] args) {
    System.out.println(new Solution().zigzagLevelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    System.out.println(new Solution().zigzagLevelOrder(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)))));
  }

  static class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      if (root == null) {
        return new ArrayList<>();
      }

      List<List<Integer>> output = new ArrayList<>();

      Stack<TreeNode> stack = new Stack<>();
      Queue<TreeNode> queue = new LinkedList<>();
      stack.push(root);
      int level = 0;
      while (!stack.isEmpty()) {
        int size = stack.size();
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < size; i++) {

          TreeNode node = stack.pop();
          nums.add(node.val);

          if (level % 2 == 0) {
            if (node.left != null) {
              queue.offer(node.left);
            }
            if (node.right != null) {
              queue.offer(node.right);
            }
          } else {
            if (node.right != null) {
              queue.offer(node.right);
            }
            if (node.left != null) {
              queue.offer(node.left);
            }
          }
        }

        while (!queue.isEmpty()) {
          stack.push(queue.poll());
        }

        output.add(nums);
        level++;
      }

      return output;
    }
  }

}
