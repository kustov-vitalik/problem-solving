package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/balanced-binary-tree/">Problem description</a>
 */
public class Solved_Problem110BalancedBinaryTree {
    public static void main(String[] args) {
        System.out.println(new Solution().isBalanced(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4,
                                        new TreeNode(8),
                                        null),
                                new TreeNode(5)),
                        new TreeNode(3,
                                new TreeNode(6),
                                null)
                )
        ));
    }

    private static class Solution {

        private boolean result = true;

        public boolean isBalanced(TreeNode root) {
            maxDepth(root);
            return result;
        }

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            if (Math.abs(l - r) > 1) {
                result = false;
            }
            return 1 + Math.max(l, r);
        }
    }
}
