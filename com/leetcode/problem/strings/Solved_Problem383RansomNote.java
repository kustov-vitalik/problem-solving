package com.leetcode.problem.strings;

/**
 * <a href="https://leetcode.com/problems/ransom-note/">Problem description</a>
 */
public class Solved_Problem383RansomNote {

  public static void main(String[] args) {

  }

  static class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
      int[] magazineCharFreq = new int[26];
      int[] noteCharFreq = new int[26];

      for (char c : magazine.toCharArray()) {
        magazineCharFreq[c - 'a'] ++;
      }

      for (char c : ransomNote.toCharArray()) {
        noteCharFreq[c - 'a'] ++;
      }

      for (int i = 0; i < magazineCharFreq.length; i++) {
        if (noteCharFreq[i] > magazineCharFreq[i]) {
          return false;
        }
      }

      return true;
    }
  }
}
