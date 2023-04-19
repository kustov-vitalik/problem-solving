package com.leetcode.problem.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/">Problem description</a>
 */
public class Solved_Problem1431KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {

    }

    private static class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            List<Boolean> output = new ArrayList<>(candies.length);
            int max = Arrays.stream(candies).max().getAsInt();
            for (int candy : candies) {
                output.add(extraCandies + candy > max);
            }
            return output;
        }
    }
}
