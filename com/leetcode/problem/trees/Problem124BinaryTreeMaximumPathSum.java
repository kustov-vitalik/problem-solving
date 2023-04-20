package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">Problem description</a>
 */
public class Problem124BinaryTreeMaximumPathSum {
    public static void main(String[] args) {

    }

    private static class Solution {
        public int maxPathSum(TreeNode root) {

            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                return root.val;
            }

            if (root.left == null) {
                int rightSum = maxPathSum(root.right);
                return Math.max(
                        root.val,
                        Math.max(
                                rightSum,
                                rightSum + root.val
                        ));
            }

            if (root.right == null) {
                int leftSum = maxPathSum(root.left);
                return Math.max(
                        root.val,
                        Math.max(
                                leftSum,
                                leftSum + root.val
                        ));
            }


            int leftSum = maxPathSum(root.left);
            int rightSum = maxPathSum(root.right);

            return Math.max(
                    root.val,
                    Math.max(
                            leftSum,
                            Math.max(
                                    rightSum,
                                    Math.max(
                                            leftSum + root.val,
                                            Math.max(
                                                    rightSum + root.val,
                                                    rightSum + leftSum + root.val
                                            ))
                            )
                    ));
        }
    }
}
