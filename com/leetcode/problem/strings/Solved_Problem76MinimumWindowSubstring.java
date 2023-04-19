package com.leetcode.problem.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/minimum-window-substring/">Problem description</a>
 */
public class Solved_Problem76MinimumWindowSubstring {

  public static void main(String[] args) {
    System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC")); // "BANC"
    System.out.println(new Solution().minWindow("a", "aa")); // ""
    System.out.println(new Solution().minWindow("a", "a")); // "a"
    System.out.println(new Solution().minWindow("bdab", "ab")); // "ab"
  }

  private static class Solution {
    public String minWindow(String s, String t) {
      Map<Character, Integer> chars = new HashMap<>();
      for (char c : t.toCharArray()) {
        chars.put(c, chars.getOrDefault(c, 0) + 1);
      }

      Map<Character, Integer> window = new HashMap<>();

      int left = 0;
      int right = 0;
      int minSize = Integer.MAX_VALUE;
      int minLeft = 0, minRight = 0;
      while (right < s.length()) {

        while (right < s.length() && !contains(window, chars)) {
          window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
          right++;
        }

        if (contains(window, chars) && (right - left + 1 < minSize)) {
            minSize = right - left + 1;
            minLeft = left;
            minRight = right;
        }

        while (left < right && contains(window, chars)) {
          Integer count = window.get(s.charAt(left));
          if (count == 1) {
            window.remove(s.charAt(left));
          } else {
            window.put(s.charAt(left), count - 1);
          }

          left++;

          if (contains(window, chars) && (right - left + 1 < minSize)) {
              minSize = right - left + 1;
              minLeft = left;
              minRight = right;
          }
        }

      }

      return s.substring(minLeft, minRight);
    }

    private boolean contains(Map<Character, Integer> window, Map<Character, Integer> chars) {

      for (var e: chars.entrySet()) {
        if (!window.containsKey(e.getKey())) {
          return false;
        }

        if (window.get(e.getKey()) < e.getValue()) {
          return false;
        }
      }

      return true;
    }
  }
}
