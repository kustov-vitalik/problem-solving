package com.leetcode.problem.strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solved_Problem43MultiplyStrings {

  public static void main(String[] args) {
//    System.out.println(new Solution().multiply("7", "8")); // 56
    System.out.println(new Solution().multiply("123", "456")); // 56088

  }

  static class Solution {

    public String multiply(String num1, String num2) {
      if ("0".equals(num1) || "0".equals(num2)) {
        return "0";
      }

      if ("1".equals(num1)) {
        return num2;
      }

      if ("1".equals(num2)) {
        return num1;
      }

      if (num1.length() < num2.length()) {
        return multiply(num2, num1);
      }

      String product = "0";
      Deque<Integer> integers = numToStack(num2);

      int power = 0;
      while (!integers.isEmpty()) {
        int digit = integers.pop();

        product = sum(product, multiply(num1, digit, power));
        power++;
      }

      return product;
    }

    private String multiply(String num, int digit, int power) {

      int carry = 0;
      Deque<Integer> integers = numToStack(num);

      StringBuilder result = new StringBuilder();
      int product;
      while (!integers.isEmpty()) {
        int n = integers.pop();
        product = n * digit + carry;
        carry = product / 10;
        result.insert(0, product % 10);
      }

      if (carry > 0) {
        result.insert(0, carry);
      }

      result.append(String.valueOf(0).repeat(power));
      return result.toString();
    }

    private String sum(String num1, String num2) {

      int carry = 0;

      Deque<Integer> n1 = numToStack(num1);
      Deque<Integer> n2 = numToStack(num2);

      StringBuilder result = new StringBuilder();

      int int1;
      int int2;
      int sum;
      while (!n1.isEmpty() && !n2.isEmpty()) {
        int1 = n1.pop();
        int2 = n2.pop();

        sum = int1 + int2 + carry;
        carry = sum / 10;
        result.insert(0, sum % 10);
      }

      while (!n1.isEmpty()) {
        int1 = n1.pop();

        sum = int1 + carry;
        carry = sum / 10;
        result.insert(0, sum % 10);
      }

      while (!n2.isEmpty()) {
        int2 = n2.pop();

        sum = int2 + carry;
        carry = sum / 10;
        result.insert(0, sum % 10);
      }

      if (carry > 0) {
        result.insert(0, "1");
      }

      return result.toString();
    }

    private Deque<Integer> numToStack(String num) {
      Deque<Integer> stack = new ArrayDeque<>();
      for (char c : num.toCharArray()) {
        stack.push(Integer.parseInt(String.valueOf(c)));
      }
      return stack;
    }
  }

}
