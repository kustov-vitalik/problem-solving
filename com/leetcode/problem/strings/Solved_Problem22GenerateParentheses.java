package com.leetcode.problem.strings;

import java.util.ArrayList;
import java.util.List;

public class Solved_Problem22GenerateParentheses {

  public static void main(String[] args) {
    System.out.println(new Solution().generateParenthesis(1));
    System.out.println(new Solution().generateParenthesis(2));
    System.out.println(new Solution().generateParenthesis(3));
  }

  static class Solution {
    public List<String> generateParenthesis(int n) {
      List<String> output = new ArrayList<>();

      doGenerate(output, n, "", 0, 0);

      return output;
    }

    private void doGenerate(List<String> output, int max, String currentPermutation, int open, int close) {
      if (currentPermutation.length() == max * 2) {
        output.add(currentPermutation);
        return;
      }

      if (open < max) {
        doGenerate(output, max, currentPermutation + "(", open + 1, close);
      }

      if (close < open) {
        doGenerate(output, max, currentPermutation + ")", open, close + 1);
      }
    }
  }

}
