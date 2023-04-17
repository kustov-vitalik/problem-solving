package com.leetcode.problem.math;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/pascals-triangle-ii/">Problem description</a>
 */
public class Solved_Problem119PascalsTriangle2 {
    public static void main(String[] args) {
        System.out.println(new Solution().getRow(0)); // [1]
        System.out.println(new Solution().getRow(1)); // [1,1]
        System.out.println(new Solution().getRow(2)); // [1,2,1]
    }

    private static class Solution {
        public List<Integer> getRow(int numRows) {
            List<List<Integer>> pascal = new ArrayList<>(numRows);
            pascal.add(List.of(1));
            pascal.add(List.of(1,1));

            numRows++;
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

            return pascal.get(numRows-1);
        }
    }
}
