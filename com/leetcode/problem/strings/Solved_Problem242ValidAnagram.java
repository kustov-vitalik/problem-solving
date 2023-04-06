package com.leetcode.problem.strings;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/valid-anagram/submissions/928947845/">Problem description</a>
 */
public class Solved_Problem242ValidAnagram {

  public static void main(String[] args) {

  }

  static class Solution {
    public boolean isAnagram(String s, String t) {
      int[] sFreq = new int[26];
      int[] tFreq = new int[26];

      for (char c : s.toCharArray()) {
        sFreq[c - 'a'] ++;
      }

      for (char c : t.toCharArray()) {
        tFreq[c - 'a'] ++;
      }

      return Arrays.equals(sFreq, tFreq);
    }
  }

}
