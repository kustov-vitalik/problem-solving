package com.leetcode.problem.trees;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/two-sum-iv-input-is-a-bst/">Problem description</a>
 */
public class Solved_Problem653TwoSum4InputIsABST {
    public static void main(String[] args) {
        System.out.println(new Solution().findTarget(
                new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2),
                                new TreeNode(4)),
                        new TreeNode(6,
                                null,
                                new TreeNode(7))),
                9
        )); // true
    }

    static class Solution {
        public boolean findTarget(TreeNode root, int k) {
            List<Integer> numbers = new ArrayList<>();
            fillSortedListFromBST(root, numbers);

            int right = numbers.size() - 1;
            for (int i = 0; i < numbers.size() - 1; i++) {
                if (binarySearch(numbers, k - numbers.get(i), i + 1, right) != -1) {
                    return true;
                }
            }

            return false;
        }

        private int binarySearch(List<Integer> nums, int key, int fromIncl, int toIncl) {
            int mid;
            while (fromIncl <= toIncl) {
                mid = (fromIncl + toIncl) >>> 1;
                if (nums.get(mid) == key) {
                    return mid;
                }

                if (nums.get(mid) > key) {
                    toIncl = mid - 1;
                } else {
                    fromIncl = mid + 1;
                }
            }

            return -1;
        }

        private void fillSortedListFromBST(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }

            fillSortedListFromBST(node.left, list);
            list.add(node.val);
            fillSortedListFromBST(node.right, list);
        }
    }
}
