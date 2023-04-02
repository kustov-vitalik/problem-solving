package com.leetcode.problem.strings;

public class Solved_Problem392IsSubsequence {

  public static void main(String[] args) {
    System.out.println(new Solution().isSubsequence("abc", "akjbfedmc")); // true
    System.out.println(new Solution().isSubsequence("abc", "akcjbfedm")); // false
    System.out.println(new Solution().isSubsequence("aaaaaa", "bbaaaa")); // false
    System.out.println(new Solution().isSubsequence("bb", "ahbgdc")); // false
  }

  static class Solution {
    public boolean isSubsequence(String s, String t) {
      if (t == null) {
        return false;
      }
      if (s == null) {
        return true;
      }
      if (s.length() == 0) {
        return true;
      }
      if (t.length() == 0) {
        return false;
      }
      if (s.length() > t.length()) {
        return false;
      } else if (s.length() == t.length()) {
        return s.equals(t);
      }

      int sPointer = 0;
      int tPointer = 0;
      int matches = 0;

      while (sPointer < s.length() && tPointer < t.length()) {
        char sChar = s.charAt(sPointer);


        while (tPointer < t.length() && t.charAt(tPointer) != sChar) {
          tPointer++;
        }

        if (tPointer < t.length() && t.charAt(tPointer) == sChar) {
          matches++;
          tPointer++;
        }

        sPointer++;
      }

      return matches == s.length();
    }
  }

}
