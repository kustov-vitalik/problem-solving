package com.leetcode.problem.strings;

/**
 * <a href="https://leetcode.com/problems/edit-distance/">Problem description</a>
 */
public class Solved_Problem72EditDistance {

  public static void main(String[] args) {
    System.out.println(new Solution().minDistance("horse", "ros")); // 3
  }

  static class Solution {

    public int minDistance(String word1, String word2) {
      if (word1.length() < word2.length()) {
        return minDistance(word2, word1);
      }

      if (word2.length() == 0) {
        return word1.length();
      }

      if (word1.equals(word2)) {
        return 0;
      }

      int[][] dp = new int[word1.length() + 1][word2.length() + 1];

      char[] chars1 = word1.toCharArray();
      char[] chars2 = word2.toCharArray();

      for (int i = 0; i < dp.length; i++) {
        for (int j = 0; j < dp[i].length; j++) {
          dp[0][j] = j;
          dp[i][0] = i;
        }
      }

      for (int i = 1; i < dp.length; i++) {
        for (int j = 1; j < dp[i].length; j++) {
          if (chars1[i - 1] == chars2[j - 1]) {
            dp[i][j] = dp[i-1][j-1];
          } else {
            dp[i][j] = Math.min(
                1 + dp[i][j - 1],
                Math.min(
                    1 + dp[i - 1][j],
                    1 + dp[i - 1][j - 1]
                )
            );
          }
        }
      }

      return dp[dp.length - 1][dp[0].length - 1];
    }

    private int minDistanceRecursive(String word1, String word2) {
      if (word1.equals(word2)) {
        return 0;
      }

      if (word1.length() < word2.length()) {
        return minDistanceRecursive(word2, word1);
      }

      if (word2.length() == 0) {
        return word1.length();
      }

      if (word1.charAt(0) == word2.charAt(0)) {
        return minDistanceRecursive(word1.substring(1), word2.substring(1));
      } else {
        return Math.min(
            1 + minDistanceRecursive(word1.substring(1), word2),
            Math.min(
                1 + minDistanceRecursive(word1.substring(1), word2.substring(1)),
                1 + minDistanceRecursive(word1, word2.substring(1))
            ));
      }
    }
  }
}
