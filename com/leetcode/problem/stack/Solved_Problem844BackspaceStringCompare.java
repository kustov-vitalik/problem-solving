package com.leetcode.problem.stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/backspace-string-compare/">Problem description</a>
 */
public class Solved_Problem844BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("ab#c", "ad#c"));
    }

    static class Solution {
        public boolean backspaceCompare(String s, String t) {
            return cleanString(s).equals(cleanString(t));
        }

        private String cleanString(String s) {
            StringBuilder stringBuilder = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '#') {
                    stack.push('#');
                } else {
                    if (stack.isEmpty()) {
                        stringBuilder.append(s.charAt(i));
                    } else {
                        stack.pop();
                    }
                }
            }
            return stringBuilder.toString();
        }
    }
}
