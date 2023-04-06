package com.leetcode.problem.arrays;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/problems/next-greater-element-i/">Problem description</a>
 */
public class Solved_Problem496NextGreaterElement1 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2}))); // [-1,3,-1]
    System.out.println(Arrays.toString(new Solution().nextGreaterElement(new int[] {2,4}, new int[] {1,2,3,4}))); // [3,-1]
  }

  static class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      int[] answer = new int[nums1.length];

      Map<Integer, Integer> mapValueToNextGreaterValue = new TreeMap<>();
      Deque<Integer> stack = new LinkedList<>();

      for (int num : nums2) {

        while (!stack.isEmpty() && num > stack.peek()) {
          mapValueToNextGreaterValue.put(stack.pop(), num);
        }

        stack.push(num);
      }

      int i = 0;
      for (int num : nums1) {
        answer[i] = mapValueToNextGreaterValue.getOrDefault(num, -1);
        i++;
      }

      return answer;
    }
  }
}
