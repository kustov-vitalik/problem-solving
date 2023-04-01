package com.leetcode.problem.strings;

import java.util.Stack;

public class Solved_Problem20ValidParentheses {

  public static void main(String[] args) {
    System.out.println(new Solution().isValid("()")); // true
    System.out.println(new Solution().isValid("()[]{}")); // true
    System.out.println(new Solution().isValid("(]")); // false
  }

  static class Solution {
    public boolean isValid(String s) {

      Stack<Character> stack = new Stack<>();

      char[] chars = s.toCharArray();
      for (char c : chars) {
        if (c == '(' || c == '[' || c == '{') {
          stack.push(c);
        } else {

          if (!stack.isEmpty()) {
            char ch = stack.peek();

            if (c == ']') {
              if (ch == '[') {
                stack.pop();
              } else {
                return false;
              }
            } else if (c == '}') {
              if (ch == '{') {
                stack.pop();
              } else {
                return false;
              }
            } else if (c == ')') {
              if (ch == '(') {
                stack.pop();
              } else {
                return false;
              }
            }
          } else {
            return false;
          }
        }
      }

      return stack.isEmpty();
    }
  }

}
