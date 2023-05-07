package com.leetcode.problem.math;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/add-strings/description/">Problem description</a>
 */
public class Solved_Problem415AddStrings {


    private static class Solution {
        public String addStrings(String num1, String num2) {
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
