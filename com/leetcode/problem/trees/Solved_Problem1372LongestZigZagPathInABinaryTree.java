package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/">Problem description</a>
 */
public class Solved_Problem1372LongestZigZagPathInABinaryTree {
    public static void main(String[] args) {
        System.out.println(new Solution().longestZigZag(
                new TreeNode(1,
                        null,
                        new TreeNode(1,
                                new TreeNode(1),
                                new TreeNode(1,
                                        new TreeNode(1, null,
                                                new TreeNode(1,
                                                        null,
                                                        new TreeNode(1)
                                                )
                                        ),
                                        new TreeNode(1)
                                )
                        )
                )
        )); // 3
    }

    private static class Solution {

        int maxZigZagDeep;

        public int longestZigZag(TreeNode root) {
            if (root == null) {
                return 0;
            }
            maxZigZagDeep = 0;
            dfsApproach(root.left, 1, true);
            dfsApproach(root.right, 1, false);
            return maxZigZagDeep;
        }

        private void dfsApproach(TreeNode node, int deep, boolean left) {
            if (node == null) {
                return;
            }

            maxZigZagDeep = Math.max(maxZigZagDeep, deep);

            if (left) {
                dfsApproach(node.left, 1, left);
                dfsApproach(node.right, deep + 1, !left);
            } else {
                dfsApproach(node.left, deep + 1, !left);
                dfsApproach(node.right, 1, left);
            }

        }
    }
}
