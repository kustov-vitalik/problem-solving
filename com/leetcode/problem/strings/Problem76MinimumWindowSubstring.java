package com.leetcode.problem.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/minimum-window-substring/">Problem description</a>
 */
public class Problem76MinimumWindowSubstring {

  public static void main(String[] args) {
    System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC")); // "BANC"
    System.out.println(new Solution().minWindow("a", "aa")); // ""
    System.out.println(new Solution().minWindow("a", "a")); // "a"
  }

  static class Solution {
    public String minWindow(String s, String t) {

      return null;
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
