package com.leetcode.problem.strings;

/**
 * <a href="https://leetcode.com/problems/length-of-last-word/">Problem description</a>
 */
public class Solved_Problem58LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("Hello World"));
        System.out.println(new Solution().lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(new Solution().lengthOfLastWord("luffy is still joyboy"));
        System.out.println(new Solution().lengthOfLastWord("l"));
    }

    private static class Solution {
        public int lengthOfLastWord(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int pointer = s.length() - 1;
            int len = 0;
            while (pointer >= 0 && s.charAt(pointer) == ' ') {
                pointer--;
            }

            while (pointer >= 0 && s.charAt(pointer) != ' ') {
                len++;
                pointer--;
            }

            return len;
        }
    }
}
