package com.leetcode.problem.strings;

/**
 * <a href="https://leetcode.com/problems/repeated-substring-pattern/">Problem description</a>
 */
public class Solved_Problem459RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(new Solution().repeatedSubstringPattern("abab")); // true
        System.out.println(new Solution().repeatedSubstringPattern("aba")); // false
        System.out.println(new Solution().repeatedSubstringPattern("abcabcabcabc")); // true
    }

    private static class Solution {
        public boolean repeatedSubstringPattern(String s) {
            var str = new StringBuilder(s).append(s);
            str.deleteCharAt(0);
            str.deleteCharAt(str.length() - 1);
            return str.toString().contains(s);
        }
    }
}
