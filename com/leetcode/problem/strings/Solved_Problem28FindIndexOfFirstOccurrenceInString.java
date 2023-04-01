package com.leetcode.problem.strings;

public class Solved_Problem28FindIndexOfFirstOccurrenceInString {

  public static void main(String[] args) {

  }

  static class Solution {
    public int strStr(String haystack, String needle) {
      return hackMethod(haystack, needle);
    }

    private int hackMethod(String haystack, String needle) {
      return haystack.indexOf(needle);
    }
  }

}
