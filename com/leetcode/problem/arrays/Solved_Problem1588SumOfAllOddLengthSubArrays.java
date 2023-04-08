package com.leetcode.problem.arrays;

/**
 * <a href="https://leetcode.com/problems/sum-of-all-odd-length-subarrays/">Problem description</a>
 */
public class Solved_Problem1588SumOfAllOddLengthSubArrays {

  public static void main(String[] args) {
    System.out.println(new Solution().sumOddLengthSubarrays(new int[] {1,4,2,5,3})); // 58
    System.out.println(new Solution().sumOddLengthSubarrays(new int[] {1,2,3})); // 12
  }

  static class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
      int n = arr.length;
      int answer = 0;
      for (int i = 0; i < n; ++i) {
        int left = i;
        int right = n - i - 1;
        answer += arr[i] * (left / 2 + 1) * (right / 2 + 1);
        answer += arr[i] * ((left + 1) / 2) * ((right + 1) / 2);
      }

      return answer;
    }
  }
}
