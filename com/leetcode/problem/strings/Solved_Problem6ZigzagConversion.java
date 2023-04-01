package com.leetcode.problem.strings;

public class Solved_Problem6ZigzagConversion {

  public static void main(String[] args) {
    Solved_Problem6ZigzagConversion problem = new Solved_Problem6ZigzagConversion();
    System.out.println("PAHNAPLSIIGYIR".equals(problem.convert("PAYPALISHIRING", 3)));
    System.out.println("PINALSIGYAHRPI".equals(problem.convert("PAYPALISHIRING", 4)));
    System.out.println("A".equals(problem.convert("A", 1)));
  }

  public String convert(String s, int numRows) {
    int len = s.length();

    if (len <= numRows) {
      return s;
    }

    if (numRows == 1) {
      return s;
    }

    int k = numRows;

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < k; i++) {
      int r = i % k;

      int n = 0;

      while (n < len) {

        int prevN = n + r;
        n += 2*k - 2;
        int nextN = n - r;

        if (prevN < len) {
          result.append(s.charAt(prevN));
        }

        if (prevN != nextN && nextN != n && (nextN < len)) {
            result.append(s.charAt(nextN));
        }
      }
    }

    return result.toString();

  }

}
