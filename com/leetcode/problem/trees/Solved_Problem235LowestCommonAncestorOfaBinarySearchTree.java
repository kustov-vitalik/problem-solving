package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">Problem description</a>
 */
public class Solved_Problem235LowestCommonAncestorOfaBinarySearchTree {

  public static void main(String[] args) {

    TreeNode node2 = new TreeNode(2,
        new TreeNode(0),
        new TreeNode(4,
            new TreeNode(3),
            new TreeNode(5)));
    TreeNode node8 = new TreeNode(8,
        new TreeNode(7),
        new TreeNode(9));

    TreeNode root = new TreeNode(6, node2, node8);

    System.out.println(new Solution().lowestCommonAncestor(root, node2, node8)); // root (6)
  }

  static class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (p == root || q == root) {
        return root;
      }

      TreeNode lastCommonAncestor = root;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        while (size > 0) {
          size--;

          TreeNode node = queue.poll();
          if (isNodeAncestor(node, p) && isNodeAncestor(node, q)) {
            lastCommonAncestor = node;
            queue.offer(node.left);
            queue.offer(node.right);
          }
        }
      }

      return lastCommonAncestor;
    }

    private boolean isNodeAncestor(TreeNode node, TreeNode child) {
      if (node == child) {
        return true;
      }

      if (node == null) {
        return false;
      }

      if (child.val < node.val) {
        return isNodeAncestor(node.left, child);
      }

      return isNodeAncestor(node.right, child);
    }
  }

}
