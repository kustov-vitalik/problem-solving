package com.leetcode.problem.stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/decode-string/">Problem description</a>
 */
public class Solved_Problem394DecodeString {

  public static void main(String[] args) {
    System.out.println(new Solved_Problem394DecodeString().decodeString("3[a]2[bc]")); // aaabcbc
    System.out.println(new Solved_Problem394DecodeString().decodeString("3[a12[c]]")); // accaccacc
  }

  public String decodeString(String s) {

    Stack<Character> stack = new Stack<>();
    Stack<String> strings = new Stack<>();
    String buffer = "";

    for (char c : s.toCharArray()) {

      if (Character.isDigit(c)) {
        stack.push(c);
      } else if (Character.isLetter(c)) {
        buffer += c;
      } else if (c == '[') {
        stack.push(c);
        strings.push(buffer);
        buffer = "";
      } else {
        // only ']' possible
        stack.pop();

        int num = 0;
        int pw = 0;
        while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
          int digit = Integer.parseInt(String.valueOf(stack.pop()));
          num = num + digit * (int) Math.pow(10, pw);
          pw++;
        }

        buffer = strings.pop() + buffer.repeat(num);
      }
    }

    return buffer;

  }


}
