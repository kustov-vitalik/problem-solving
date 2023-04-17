package com.leetcode.problem.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/word-break/">Problem description</a>
 */
public class Solved_Problem139WordBreak {
    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("leetcode", List.of("leet", "code"))); // true
        System.out.println(new Solution().wordBreak("applepenapple", List.of("apple", "pen"))); // true
        System.out.println(new Solution().wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // false
        System.out.println(new Solution().wordBreak("cars", List.of("car", "ca", "rs"))); // true
        System.out.println(new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"))); // false
        System.out.println(new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", List.of("aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa", "ba"))); // ?
    }

    private static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null || s.length() == 0) {
                return false;
            }

            int n = s.length();
            boolean[] dp = new boolean[n];
            Set<String> dict = new HashSet<>(wordDict);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    String sub = s.substring(j, i + 1);
                    if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[n - 1];
        }
    }
}
