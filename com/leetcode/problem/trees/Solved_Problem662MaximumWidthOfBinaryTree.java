package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/maximum-width-of-binary-tree/">Problem description</a>
 */
public class Solved_Problem662MaximumWidthOfBinaryTree {
    public static void main(String[] args) {

    }

    private static class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<TreeNode> q = new LinkedList<>();
            Map<TreeNode, Integer> m = new HashMap<>();
            q.offer(root);
            m.put(root, 1);
            int currentWidth = 0;
            int maxWidth = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                int start = 0;
                int end = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (i == 0) {
                        start = m.get(node);
                    }

                    if (i == size - 1) {
                        end = m.get(node);
                    }

                    if (node.left != null) {
                        m.put(node.left, m.get(node) * 2);
                        q.offer(node.left);
                    }

                    if (node.right != null) {
                        m.put(node.right, m.get(node) * 2 + 1);
                        q.offer(node.right);
                    }
                }
                currentWidth = end - start + 1;
                maxWidth = Math.max(currentWidth, maxWidth);
            }

            return maxWidth;
        }
    }
}
