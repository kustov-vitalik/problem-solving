package com.leetcode.problem.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/happy-number/">Problem Description</a>
 */
public class Solved_Problem202HappyNumber {

  public static void main(String[] args) {
    System.out.println(new Solution().isHappy(19)); // true
    System.out.println(new Solution().isHappy(2)); // false
  }

  static class Solution {
    public boolean isHappy(int n) {
      Set<Integer> sums = new HashSet<>();

      do {

        n = digits(n).stream().map(i -> i * i).mapToInt(i -> i).sum();
        if (sums.contains(n)) {
          return false;
        }
        sums.add(n);
      } while (n != 1);


      return true;
    }

    private List<Integer> digits(int n) {
      List<Integer> digits = new ArrayList<>();

      while (n > 0) {
        digits.add(n % 10);
        n /= 10;
      }

      return digits;
    }
  }

}
