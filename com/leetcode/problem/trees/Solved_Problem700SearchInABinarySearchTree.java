package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/search-in-a-binary-search-tree/submissions/933632325/">Problem description</a>
 */
public class Solved_Problem700SearchInABinarySearchTree {
    public static void main(String[] args) {

    }

    static class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }

            if (root.val == val) {
                return root;
            }

            if (val < root.val) {
                return searchBST(root.left, val);
            }

            return searchBST(root.right, val);
        }
    }
}
