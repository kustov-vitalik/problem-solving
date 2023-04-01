package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Solved_Problem236LowestCommonAncestorOfaBinaryTree {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == p || root == q) {
      return root;
    }

    TreeNode lastCommonAnc = root;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size > 0) {
        size--;

        var node = queue.poll();
        if (isAnc(node, q) && isAnc(node, p)) {
          lastCommonAnc = node;

          queue.offer(node.left);
          queue.offer(node.right);
        }
      }
    }

    return lastCommonAnc;
  }

  private boolean isAnc(TreeNode node, TreeNode child) {
    if (node == child) {
      return true;
    }

    if (node == null) {
      return false;
    }

    return isAnc(node.left, child) || isAnc(node.right, child);
  }

}
