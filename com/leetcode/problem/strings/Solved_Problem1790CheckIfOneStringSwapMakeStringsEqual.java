package com.leetcode.problem.strings;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/">Problem description</a>
 */
public class Solved_Problem1790CheckIfOneStringSwapMakeStringsEqual {

  public static void main(String[] args) {
    System.out.println(new Solution().areAlmostEqual("bank", "kanb")); // true
    System.out.println(new Solution().areAlmostEqual("asd", "wer")); // false
    System.out.println(new Solution().areAlmostEqual("asd", "asd")); // true
    System.out.println(new Solution().areAlmostEqual("a", "d")); // false
    System.out.println(new Solution().areAlmostEqual("aa", "ac")); // false
  }

  static class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
      if (s1.equals(s2)) {
        return true;
      }

      int left = 0;
      int right = s1.length() - 1;
      char[] chars1 = s1.toCharArray();
      char[] chars2 = s2.toCharArray();

      while (left < right) {

        while (left < right && chars1[left] == chars2[left]) {
          left++;
        }

        while (left < right && chars1[right] == chars2[right]) {
          right--;
        }

        if (left == right && chars1[left] == chars2[left]) {
          return true;
        }

        char temp = chars1[left];
        chars1[left] = chars1[right];
        chars1[right] = temp;
        break;
      }

      return Arrays.equals(chars1, chars2);
    }
  }
}
