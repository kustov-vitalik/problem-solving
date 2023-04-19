package com.leetcode.problem.strings;

/**
 * <a href="https://leetcode.com/problems/merge-strings-alternately/">Problem description</a>
 */
public class Solved_Problem1768MergeStringsAlternately {
    public static void main(String[] args) {
        System.out.println(new Solution().mergeAlternately("abc", "qwe"));
        System.out.println(new Solution().mergeAlternately("abc", "qwe345"));
        System.out.println(new Solution().mergeAlternately("abc234", "qwe"));
    }

    private static class Solution {
        public String mergeAlternately(String word1, String word2) {

            StringBuilder stringBuilder = new StringBuilder();
            int pointer1 = 0;
            int pointer2 = 0;

            while (pointer1 < word1.length() && pointer2 < word2.length()) {
                stringBuilder.append(word1.charAt(pointer1));
                pointer1++;

                stringBuilder.append(word2.charAt(pointer2));
                pointer2++;
            }

            while (pointer1 < word1.length()) {
                stringBuilder.append(word1.charAt(pointer1));
                pointer1++;
            }

            while (pointer2 < word2.length()) {
                stringBuilder.append(word2.charAt(pointer2));
                pointer2++;
            }

            return stringBuilder.toString();
        }
    }
}
