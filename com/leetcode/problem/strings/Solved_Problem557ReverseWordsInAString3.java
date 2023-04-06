package com.leetcode.problem.strings;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii">Problem description</a>
 */
public class Solved_Problem557ReverseWordsInAString3 {

  public static void main(String[] args) {
    System.out.println(new Solution().reverseWords("Let's take LeetCode contest").equals("s'teL ekat edoCteeL tsetnoc"));
    System.out.println(new Solution().reverseWords("God Ding").equals("doG gniD"));
  }

  static class Solution {
    public String reverseWords(String s) {
      return Arrays.stream(s.split(" "))
          .map(this::reverse)
          .collect(Collectors.joining(" "));
    }

    private String reverse(String s) {
      int left = 0;
      int right = s.length() - 1;
      char[] chars = s.toCharArray();
      while (left < right) {
        char t = chars[left];
        chars[left] = chars[right];
        chars[right] = t;
        left++;
        right--;
      }
      return String.valueOf(chars);
    }
  }
}
