package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/invert-binary-tree/">Problem description</a>
 */
public class Solved_Problem226InvertBinaryTree {
    public static void main(String[] args) {

    }

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            invertTree(root.left);
            invertTree(root.right);

            return root;
        }
    }
}
