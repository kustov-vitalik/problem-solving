package com.leetcode.problem.strings;

public class Problem10RegularExpressionMatching {

  public static void main(String[] args) {
    System.out.println(new Solution().isMatch("aa", "a")); // false
    System.out.println(new Solution().isMatch("aa", "a.")); // true
    System.out.println(new Solution().isMatch("aa", "b.")); // false
  }

  static class Solution {

    public boolean isMatch(String s, String p) {
      if (!p.contains("*") && !p.contains(".")) {
        return p.equals(s);
      }

      if (!p.contains("*") && p.contains(".")) {
        if (p.length() != s.length()) {
          return false;
        }

        for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) != p.charAt(i) && p.charAt(i) != '.') {
            return false;
          }
        }

        return true;
      }

      

      return false;
    }
  }

}
