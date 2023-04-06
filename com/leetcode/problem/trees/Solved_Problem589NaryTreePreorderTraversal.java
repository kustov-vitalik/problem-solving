package com.leetcode.problem.trees;

import com.leetcode.common.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/n-ary-tree-preorder-traversal/">Problem description</a>
 */
public class Solved_Problem589NaryTreePreorderTraversal {

  public static void main(String[] args) {

  }

  static class Solution {
    public List<Integer> preorder(Node root) {

      List<Integer> items = new ArrayList<>();

      preorder(root, items);

      return items;

    }

    private void preorder(Node root, List<Integer> items) {
      if (root == null) {
        return;
      }

      items.add(root.val);
      for (Node node : root.children) {
        preorder(node, items);
      }
    }
  }

}
