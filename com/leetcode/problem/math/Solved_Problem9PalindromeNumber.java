package com.leetcode.problem.math;

import java.util.ArrayList;
import java.util.List;

public class Solved_Problem9PalindromeNumber {

  public static void main(String[] args) {
    System.out.println(new Solution().isPalindrome(121) == true);
    System.out.println(new Solution().isPalindrome(1212) == false);
    System.out.println(new Solution().isPalindrome(-121) == false);
  }

  static class Solution {
    public boolean isPalindrome(int x) {
      if (x < 0) {
        return false;
      }

      List<Integer> digits = new ArrayList<>();
      while (x > 0) {
        digits.add(x%10);
        x /= 10;
      }

      for (int i = 0; i < digits.size() / 2; i++) {
        if (digits.get(i) != digits.get(digits.size() - 1 - i)) {
          return false;
        }
      }

      return true;
    }
  }

}
