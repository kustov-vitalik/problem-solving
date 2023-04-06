package com.leetcode.problem.math;

import java.util.ArrayList;
import java.util.List;

public class Solved_Problem118PascalsTriangle {

  public static void main(String[] args) {
    System.out.println(new Solution().generate(3));
    System.out.println(new Solution().generate(4));
    System.out.println(new Solution().generate(30));
  }

  static class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> pascal = new ArrayList<>(numRows);
      pascal.add(0, List.of(1));
      if (numRows == 1) {
        return pascal;
      }
      pascal.add(1, List.of(1,1));
      if (numRows == 2) {
        return pascal;
      }

      int counter = 2;
      while (counter < numRows) {

        List<Integer> list = new ArrayList<>(counter);
        list.add(1);
        for (int i = 0; i < counter - 1; i++) {
          List<Integer> prev = pascal.get(counter - 1);
          list.add(prev.get(i) + prev.get(i + 1));
        }
        list.add(1);
        pascal.add(list);

        counter++;
      }

      return pascal;
    }
  }

}
