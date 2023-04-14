package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/insert-into-a-binary-search-tree/">Problem description</a>
 */
public class Solved_Problem701InsertIntoABinarySearchTree {
    public static void main(String[] args) {

    }

    static class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            if (val < root.val) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }

            return root;
        }
    }
}
