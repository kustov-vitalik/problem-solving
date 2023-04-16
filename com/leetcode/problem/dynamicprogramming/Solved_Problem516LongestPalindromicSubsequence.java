package com.leetcode.problem.dynamicprogramming;

import com.leetcode.common.Utils;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-subsequence/">Problem description</a>
 */
public class Solved_Problem516LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindromeSubseq("bbbab")); // 4
        System.out.println(new Solution().longestPalindromeSubseq("cbbd")); // 2
        System.out.println(new Solution().longestPalindromeSubseq("yacbbdat")); // 4 abba
        System.out.println(new Solution().longestPalindromeSubseq("yacbrbdat")); // 5 abrba
    }

    static class Solution {
        public int longestPalindromeSubseq(String s) {

            char[] chars = s.toCharArray();
            if (chars.length == 1) {
                return 1;
            }

            char[] reversedChars = new StringBuilder(s).reverse().toString().toCharArray();
            int[][] longestCommonSubsequence = new int[chars.length + 1][reversedChars.length + 1];
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < reversedChars.length; j++) {
                    if (chars[i] == reversedChars[j]) {
                        longestCommonSubsequence[i+1][j+1] = longestCommonSubsequence[i][j] + 1;
                    } else {
                        longestCommonSubsequence[i+1][j+1] = Math.max(
                                longestCommonSubsequence[i+1][j],
                                longestCommonSubsequence[i][j+1]
                        );
                    }
                }
            }

            return longestCommonSubsequence[chars.length][reversedChars.length];
        }

    }
}
