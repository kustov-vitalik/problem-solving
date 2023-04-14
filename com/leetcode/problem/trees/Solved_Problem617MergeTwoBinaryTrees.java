package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;

import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/merge-two-binary-trees/">Problem description</a>
 */
public class Solved_Problem617MergeTwoBinaryTrees {

    public static void main(String[] args) {

    }

    static class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

            if (root1 == null && root2 == null) {
                return null;
            }

            if (root1 != null && root2 != null) {
                return new TreeNode(root1.val + root2.val,
                        mergeTrees(root1.left, root2.left),
                        mergeTrees(root1.right, root2.right)
                );
            }

            return Objects.requireNonNullElse(root1, root2);
        }
    }
}
