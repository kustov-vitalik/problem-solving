package com.leetcode.problem.arrays;

public class Solved_Problem1491AverageSalaryExcludingTheMinimumAndMaximumSalary {

  public static void main(String[] args) {

  }

  static class Solution {
    public double average(int[] salary) {

      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      int sum = 0;

      for (int s : salary) {
        max = Math.max(max, s);
        min = Math.min(min, s);
        sum += s;
      }

      return 1.0 * (sum - max - min)/(salary.length - 2);
    }
  }

}
