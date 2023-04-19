package com.leetcode.problem.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/simplify-path/">Problem description</a>
 */
public class Solved_Problem71SimplifyPath {
    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/home/")); // "/home"
        System.out.println(new Solution().simplifyPath("/../")); // "/"
        System.out.println(new Solution().simplifyPath("/home///foo/")); // "/home/foo"
        System.out.println(new Solution().simplifyPath("/home//.//./foo/")); // "/home/foo"
    }

    private static class Solution {
        public String simplifyPath(String path) {
            String[] parts = path.split("/");
            List<String> partList = Arrays.stream(parts)
                    .filter(a -> !a.equals("") && !a.equals("."))
                    .collect(Collectors.toList());
            Stack<String> stack = new Stack<>();
            for (String part : partList) {
                if (part.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }

                } else {
                    stack.push("/");
                    stack.push(part);
                }
            }

            if (stack.isEmpty()) {
                return "/";
            }

            StringBuilder stringBuilder = new StringBuilder();
            Stack<String> resultStack = new Stack<>();
            while (!stack.isEmpty()) {
                resultStack.push(stack.pop());
            }
            while (!resultStack.isEmpty()) {
                stringBuilder.append(resultStack.pop());
            }

            return stringBuilder.toString();
        }
    }
}
