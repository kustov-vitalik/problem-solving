package com.leetcode.problem.binarysearcg;

/**
 * <a href="https://leetcode.com/problems/find-smallest-letter-greater-than-target">Problem description</a>
 */
public class Solved_Problem744FindSmallestLetterGreaterThanTarget {

  public static void main(String[] args) {
    System.out.println(new Solution().nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'a')); // c
    System.out.println(new Solution().nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'c')); // f
    System.out.println(new Solution().nextGreatestLetter(new char[] {'e', 'e', 'n', 'n'}, 'e')); // n
  }

  static class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
      int left = 0;
      int right = letters.length - 1;
      int mid;
      while (left <= right) {
        mid = (left + right) >>> 1;

        if (mid > 0 && letters[mid] > target && letters[mid - 1] <= target) {
          return letters[mid];
        }

        if (letters[mid] <= target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      return letters[0];
    }
  }

}
