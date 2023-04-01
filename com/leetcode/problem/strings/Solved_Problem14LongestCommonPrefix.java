package com.leetcode.problem.strings;

public class Solved_Problem14LongestCommonPrefix {

  public static void main(String[] args) {
    System.out.println(new Solution().longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // "fl"
    System.out.println(new Solution().longestCommonPrefix(new String[]{"god", "flow", "flight"})); // ""
  }

  static class Solution {
    public String longestCommonPrefix(String[] strs) {
      if (strs.length == 1) {
        return strs[0];
      }

      String shortest = strs[0];
      for (String str : strs) {
        if (str.length() < shortest.length()) {
          shortest = str;
        }
      }

      String prefix = "";

      char[] chars = shortest.toCharArray();
      for (int i = 0; i < chars.length; i++) {

        boolean ok = true;
        for (String str : strs) {
          if (chars[i] != str.charAt(i)) {
            ok = false;
            break;
          }
        }

        if (ok) {
          prefix += chars[i];
        } else {
          break;
        }

      }

      return prefix;
    }
  }

}
