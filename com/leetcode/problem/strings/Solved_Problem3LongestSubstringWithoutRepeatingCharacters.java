package com.leetcode.problem.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Problem description</a>
 */
public class Solved_Problem3LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    System.out.println(
        new Solved_Problem3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(
            "abcabcbb")); // 3
    System.out.println(
        new Solved_Problem3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(
            "bbbbbbbb")); // 1
    System.out.println(
        new Solved_Problem3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(
            "bbbbbbbba")); // 1
    System.out.println(
        new Solved_Problem3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(
            "pwwkew")); // 3
    System.out.println(
        new Solved_Problem3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("")); // 0
    System.out.println(
        new Solved_Problem3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(
            "aab")); // 2
    System.out.println(
        new Solved_Problem3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(
            "dvdf")); // 3
  }

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    if (s.length() == 1) {
      return 1;
    }

    int from = 0;
    int to = 0;
    Set<Character> chars = new HashSet<>();
    int mSize = 0;

    while (to < s.length()) {
      if (!chars.contains(s.charAt(to))) {
        chars.add(s.charAt(to));
        mSize = Math.max(mSize, chars.size());
      } else {

        while (from < to) {
          if (s.charAt(from) == s.charAt(to)) {
            from++;
            break;
          } else {
            chars.remove(s.charAt(from));
            from++;
          }

        }
      }

      to++;
    }

    return mSize;
  }

}
