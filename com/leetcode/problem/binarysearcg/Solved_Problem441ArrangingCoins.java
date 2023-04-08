package com.leetcode.problem.binarysearcg;

/**
 * <a href="https://leetcode.com/problems/arranging-coins/">Problem description</a>
 */
public class Solved_Problem441ArrangingCoins {

  public static void main(String[] args) {
    System.out.println(new Solution().arrangeCoins(5)); // 2
    System.out.println(new Solution().arrangeCoins(8)); // 3
    System.out.println(new Solution().arrangeCoins(1804289383)); // 60070
  }

  static class Solution {

    public int arrangeCoins(int n) {

      return binarySearch(n);

    }

    private int binarySearch(int n) {
      int left = 1;
      int right = 65535;
      int mid;
      int val;
      while (left <= right) {
        mid = (left + right) >>> 1;

        if (mid % 2 == 0) {
          val = mid/2 * (mid + 1);
        } else {
          val = (mid + 1)/2 * mid;
        }
        if (val == n) {
          return mid;
        } else if (val > n) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      return right;
    }

    /**
     * Uses long and double.
     */
    public int mathSolution(int n) {
      return (int) ((Math.sqrt(8L * n + (double) 1) - 1) / 2);
    }
  }

}
