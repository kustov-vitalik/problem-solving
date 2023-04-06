package com.leetcode.problem.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-palindrome/">Problem description</a>
 */
public class Solved_Problem409LongestPalindrome {

  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindrome("abccccdd")); // 7
    System.out.println(new Solution().longestPalindrome("a")); // 1
    System.out.println(new Solution().longestPalindrome("aA")); // 1
    System.out.println(new Solution().longestPalindrome("aAA")); // 3
  }

  static class Solution {
    public int longestPalindrome(String s) {

      Map<Character, Integer> charCounts = new HashMap<>();

      for (char c : s.toCharArray()) {
        if (charCounts.containsKey(c)) {
          charCounts.put(c, charCounts.get(c) + 1);
        } else {
          charCounts.put(c, 1);
        }
      }

      int maxLen = 0;
      boolean oddExist = false;
      for (var e: charCounts.entrySet()) {
        boolean even = e.getValue() % 2 == 0;
        maxLen += even ? e.getValue() : e.getValue() - 1;
        if (!even) {
          oddExist = true;
        }
      }

      if (oddExist) {
        maxLen++;
      }

      return maxLen;
    }
  }
}
