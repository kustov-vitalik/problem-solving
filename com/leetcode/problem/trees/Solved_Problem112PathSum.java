package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/path-sum/">Problem description</a>
 */
public class Solved_Problem112PathSum {
    public static void main(String[] args) {

    }

    static class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }

            if (root.left == null && root.right == null && root.val == targetSum) {
                return true;
            }

            return hasPathSum(root.left, targetSum - root.val)
                    || hasPathSum(root.right, targetSum - root.val);
        }
    }
}
