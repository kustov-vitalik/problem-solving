package com.leetcode.problem.strings;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/reverse-string/">Problem description</a>
 */
public class Solved_Problem344ReverseString {

  public static void main(String[] args) {
    char[] s = {'a', 'b', 'c'};
    new Solution().reverseString(s);
    System.out.println(Arrays.toString(s));
  }

  static class Solution {
    public void reverseString(char[] s) {

      int left = 0;
      int right = s.length - 1;

      while (left < right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        left++;
        right--;
      }

    }
  }

}
