package com.leetcode.problem.strings;

/**
 * <a href="https://leetcode.com/problems/permutation-in-string/">Problem description</a>
 */
public class Solved_Problem567PermutationInString {

  public static void main(String[] args) {
    System.out.println(new Solution().checkInclusion("ab", "eidbaooo")); // true
    System.out.println(new Solution().checkInclusion("ab", "eidboaoo")); // false
    System.out.println(new Solution().checkInclusion("ab", "eidboaooba")); // true
    System.out.println(new Solution().checkInclusion("ab", "badboaooff")); // true
  }

  static class Solution {
    public boolean checkInclusion(String s1, String s2) {

      if (s2.length() < s1.length()) {
        return false;
      }

      int[] s1charFreq = new int[26];
      int[] s2charFreq = new int[26];

      for (char c : s1.toCharArray()) {
        s1charFreq[c - 'a']++;
      }

      char[] s2chars = s2.toCharArray();

      int left = 0;
      int right = s1.length();

      for (int i = left; i < right; i++) {
        s2charFreq[s2chars[i] - 'a'] ++;
      }

      while (right < s2chars.length) {


        //System.out.println(Arrays.toString(s2charFreq));

        if (s2containsS1(s1charFreq, s2charFreq)) {
          return true;
        }

        s2charFreq[s2chars[left] - 'a'] --;
        s2charFreq[s2chars[right] - 'a'] ++;

        left++;
        right++;
      }

      if (s2containsS1(s1charFreq, s2charFreq)) {
        return true;
      }

      return false;
    }

    private boolean s2containsS1(int[] s1charFreq, int[] s2charFreq) {
      for (int i = 0; i < s1charFreq.length; i++) {
        if (s1charFreq[i] > s2charFreq[i]) {
          return false;
        }
      }
      return true;
    }
  }
}
