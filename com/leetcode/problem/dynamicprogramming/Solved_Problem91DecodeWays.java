package com.leetcode.problem.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/decode-ways/">Problem description</a>
 */
public class Solved_Problem91DecodeWays {
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("12")); // 2
        System.out.println(new Solution().numDecodings("226")); // 3
        System.out.println(new Solution().numDecodings("06")); // 0
        System.out.println(new Solution().numDecodings("27")); // 1
        System.out.println(new Solution().numDecodings("10")); // 1
        System.out.println(new Solution().numDecodings("2101")); // 1
        System.out.println(new Solution().numDecodings("1123")); // 5
    }

    private static class Solution {
        public int numDecodings(String s) {
            int dp1 = 1, dp2 = 0, n = s.length();
            for (int i = n - 1; i >= 0; i--) {
                int dp = s.charAt(i) == '0' ? 0 : dp1;
                if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    dp += dp2;
                }
                dp2 = dp1;
                dp1 = dp;
            }
            return dp1;
        }
    }
}
