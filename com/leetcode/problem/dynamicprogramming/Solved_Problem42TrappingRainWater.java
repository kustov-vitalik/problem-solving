package com.leetcode.problem.dynamicprogramming;

import java.util.Map;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/problems/trapping-rain-water/">Problem description</a>
 */
public class Solved_Problem42TrappingRainWater {

    public static void main(String[] args) {

        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
        System.out.println(new Solution().trap(new int[]{4, 2, 0, 3, 2, 5})); // 9
        System.out.println(new Solution().trap(new int[]{5, 4, 1, 2})); // 1
        System.out.println(new Solution().trap(new int[]{5, 2, 1, 2, 1, 5})); // 14
        System.out.println(new Solution().trap(new int[]{6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3})); // 83
        System.out.println(new Solution().trap(new int[]{4,3,3,9,3,0,9,2,8,3})); // 23

    }

    static class Solution {

        TreeMap<Integer, Integer> maximumMap;
        int sum;
        int maxKey;

        public int trap(int[] height) {

            maxKey = -1;
            sum = 0;

            fillMaximumMap(height);

            if (maximumMap.size() <= 1) {
                return sum;
            }

            calcSumRight(height, maxKey);
            calcSumLeft(height, maxKey);

            return sum;
        }

        private void calcSumLeft(int[] height, int fromIncl) {
            Map.Entry<Integer, Integer> from = maximumMap.floorEntry(fromIncl);
            Map.Entry<Integer, Integer> max = maximumMap.floorEntry(fromIncl - 1);
            if (max == null) {
                return;
            }

            int M = Math.min(from.getValue(), max.getValue());
            for (int i = max.getKey() + 1; i < from.getKey(); i++) {
                int delta = M - height[i];
                if (delta > 0) {
                    sum += delta;
                }
            }

            calcSumLeft(height, max.getKey());
        }

        private void calcSumRight(int[] height, int fromIncl) {
            Map.Entry<Integer, Integer> from = maximumMap.ceilingEntry(fromIncl);
            Map.Entry<Integer, Integer> max = maximumMap.ceilingEntry(fromIncl + 1);
            if (max == null) {
                return;
            }

            int M = Math.min(from.getValue(), max.getValue());
            for (int i = from.getKey() + 1; i < max.getKey(); i++) {
                int delta = M - height[i];
                if (delta > 0) {
                    sum += delta;
                }
            }

            calcSumRight(height, max.getKey());
        }

        private void fillMaximumMap(int[] height) {
            maximumMap = new TreeMap<>();
            int left;
            int right;

            int max = Integer.MIN_VALUE;

            for (int i = 0; i < height.length; i++) {
                left = i == 0 ? Integer.MIN_VALUE : height[i - 1];
                right = i == height.length - 1 ? Integer.MIN_VALUE : height[i + 1];
                if (left <= height[i] && height[i] > right) {
                    maximumMap.put(i, height[i]);

                    if (height[i] > max) {
                        max = height[i];
                        maxKey = i;
                    }
                }
            }

            Map.Entry<Integer, Integer> maxEntry = cleanBefore(max);
            Map.Entry<Integer, Integer> secondMaxEntry = cleanAfter(max);

            left = maxEntry.getKey();
            right = secondMaxEntry.getKey();
            while (left < right) {
                Map.Entry<Integer, Integer> entry = maximumMap.ceilingEntry(left);
                if (entry.getValue() < max && entry.getKey() < right) {
                    maximumMap.remove(left);
                }
                left++;
            }

        }

        private Map.Entry<Integer, Integer> cleanAfter(int max) {
            Map.Entry<Integer, Integer> current;
            Map.Entry<Integer, Integer> prev;
            prev = null;
            Map.Entry<Integer, Integer> secondMaxEntry = null;
            current = maximumMap.lastEntry();
            while (current != null) {
                if (current.getValue() == max) {
                    secondMaxEntry = current;
                    break;
                }

                if (prev != null && (current.getValue() < prev.getValue())) {
                    maximumMap.remove(current.getKey());
                } else {
                    prev = current;
                }
                current = maximumMap.lowerEntry(current.getKey());
            }
            return secondMaxEntry;
        }

        private Map.Entry<Integer, Integer> cleanBefore(int max) {
            Map.Entry<Integer, Integer> prev = null;
            Map.Entry<Integer, Integer> maxEntry = null;
            Map.Entry<Integer, Integer> current = maximumMap.firstEntry();
            while (current != null) {
                if (current.getValue() == max) {
                    maxEntry = current;
                    break;
                }

                if (prev != null && (current.getValue() < prev.getValue())) {
                    maximumMap.remove(current.getKey());
                } else {
                    prev = current;
                }
                current = maximumMap.higherEntry(current.getKey());
            }

            return maxEntry;
        }
    }


}
