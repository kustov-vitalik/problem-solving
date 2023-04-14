package com.leetcode.problem.strings;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/removing-stars-from-a-string/">Problem description</a>
 */
public class Problem2390RemovingStarsFromAString {
    public static void main(String[] args) {
        System.out.println(new Solution().removeStars("leet**cod*e")); // lecoe
    }

    static class Solution {
        public String removeStars(String s) {
            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] == '*') {
                    stack.push(chars[i]);
                } else {
                    if (stack.isEmpty()) {
                        stringBuilder.append(chars[i]);
                    } else {
                        stack.pop();
                    }
                }
            }
            return stringBuilder.reverse().toString();
        }
    }
}
