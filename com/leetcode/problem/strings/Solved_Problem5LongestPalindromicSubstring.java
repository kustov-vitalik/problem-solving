package com.leetcode.problem.strings;

public class Solved_Problem5LongestPalindromicSubstring {

  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindrome("rbaba")); // bab || aba
    System.out.println(new Solution().longestPalindrome("cbba")); // bb
  }

  private static class Solution {
    public String longestPalindrome(String s) {
      return solution3(s); // beats 95%
      //return solution2(s); // beats 5%
      //return solution1(s); // time limit
    }

    private String solution3(String s) {

      int start = -1;
      int maxLen = 0;
      for (int i = 0; i < s.length(); i++) {
        int len1 = palindromeLen(s, i, i);
        int len2 = palindromeLen(s, i, i + 1);
        if (Math.max(len1, len2) > maxLen) {
          start = i;
          maxLen = Math.max(len1, len2);
        }
      }

      int from = start - (maxLen-1)/2;
      int to = from + maxLen;

      return s.substring(from, to);
    }

    private int palindromeLen(String s, int left, int right) {

      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
      }

      return right - left - 1;
    }

    public String solution2(String s) {
      if (isPalindrome(s)) {
        return s;
      }

      int window = s.length() - 1;

      String t = null;
      while (window > 1) {

        for (int i = 0; i <= s.length() - window; i++) {
          t = s.substring(i, i + window);
          if (isPalindrome(t)) {
            return t;
          }
        }

        window--;
      }

      return s.substring(0, 1);
    }

    public String solution1(String s) {
      if (isPalindrome(s)) {
        return s;
      }

      if (s.length() == 1) {
        return s;
      }

      String left = longestPalindrome(s.substring(1));
      String right = longestPalindrome(s.substring(0, s.length() - 1));

      return left.length() >= right.length() ? left : right;
    }

    public static boolean isPalindrome(String s) {
      for (int i = 0; i < s.length() / 2; i++) {
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
          return false;
        }
      }
      return true;
    }
  }


}
