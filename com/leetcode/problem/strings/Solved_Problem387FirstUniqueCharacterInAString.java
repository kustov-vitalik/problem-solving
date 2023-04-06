package com.leetcode.problem.strings;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/first-unique-character-in-a-string">Problem description</a>
 */
public class Solved_Problem387FirstUniqueCharacterInAString {

  public static void main(String[] args) {
    System.out.println(new Solution().firstUniqChar("leetcode")); // 0
    System.out.println(new Solution().firstUniqChar("loveleetcode")); // 2
    System.out.println(new Solution().firstUniqChar("aabb")); // -1
    System.out.println(new Solution().firstUniqChar("aaadd")); // -1
  }

  static class Solution {
    public int firstUniqChar(String s) {

      int[] chars = new int[26];
      Arrays.fill(chars, -1);

      char[] string = s.toCharArray();
      for (int i = 0; i < string.length; i++) {
        char c = string[i];

        if (chars[c - 'a'] == -1) {
          chars[c - 'a'] = i;
        } else {
          if (i != 1) {
            chars[c - 'a'] = -(Math.abs(chars[c - 'a']) + i);
          } else {
            chars[c - 'a'] = -2;
          }
        }
      }

      int minNonNegativeIndex = s.length() + 1;
      for (int c : chars) {
        if (c >= 0) {
          minNonNegativeIndex = Math.min(minNonNegativeIndex, c);
        }
      }

      return minNonNegativeIndex == s.length() + 1 ? -1 : minNonNegativeIndex;
    }
  }
}
