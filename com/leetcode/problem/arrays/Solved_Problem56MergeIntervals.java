package com.leetcode.problem.arrays;

import com.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/merge-intervals/">Problem description</a>
 */
public class Solved_Problem56MergeIntervals {
    public static void main(String[] args) {
        Utils.printMatrix(new Solution().merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        }));
    }

    private static class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length <= 1) {
                return intervals;
            }

            Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

            List<int[]> result = new ArrayList<>();
            int[] newInterval = intervals[0];
            result.add(newInterval);
            for (int[] interval : intervals) {
                if (interval[0] <= newInterval[1]) {
                    newInterval[1] = Math.max(newInterval[1], interval[1]);
                } else {
                    newInterval = interval;
                    result.add(newInterval);
                }
            }

            return result.toArray(new int[result.size()][]);
        }
    }
}
