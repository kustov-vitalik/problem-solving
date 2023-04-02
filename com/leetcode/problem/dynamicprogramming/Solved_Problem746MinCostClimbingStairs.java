package com.leetcode.problem.dynamicprogramming;

public class Solved_Problem746MinCostClimbingStairs {

  public static void main(String[] args) {
    System.out.println(new Solution().minCostClimbingStairs(new int[] {10, 15, 20})); // 15
    System.out.println(new Solution().minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1})); // 6
  }

  static class Solution {
    public int minCostClimbingStairs(int[] cost) {
      int prevPrev = cost[0];
      int prev = cost[1];
      int current = Math.min(prev, prevPrev);

      for (int i = 2; i < cost.length; i++) {
        current = Math.min(prevPrev, prev) + cost[i];
        prevPrev = prev;
        prev = current;
      }

      return Math.min(current, prevPrev);
    }
  }

}
