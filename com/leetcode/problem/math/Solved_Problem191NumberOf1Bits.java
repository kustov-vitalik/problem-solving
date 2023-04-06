package com.leetcode.problem.math;

/**
 * <a href="https://leetcode.com/problems/number-of-1-bits">Problem description</a>
 */
public class Solved_Problem191NumberOf1Bits {

  public static void main(String[] args) {
    System.out.println(new Solution().hammingWeight(0b00000000000000000000000000001011)); // 3
    System.out.println(new Solution().hammingWeight(0b00000000000000000000000010000000)); // 1
    System.out.println(new Solution().hammingWeight(0b11111111111111111111111111111101)); // 31
  }

  static public class Solution {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

      int counter = 0;

      for (int i = 0; i < 32; i++) {
        if ((n & 0b01) > 0) {
          counter++;
        }

        n >>>= 1;
      }

      return counter;
    }
  }

}
