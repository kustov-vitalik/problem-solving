package com.leetcode.problem.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/letter-case-permutation/">Problem description</a>
 */
public class Solved_Problem784LetterCasePermutation {
    public static void main(String[] args) {
        System.out.println(new Solution().letterCasePermutation("a1b2"));
    }

    static class Solution {
        public List<String> letterCasePermutation(String s) {
            List<String> output = new ArrayList<>();
            fillPermutations(output, s, 0);
            return output;
        }

        private void fillPermutations(List<String> output, String s, int position) {
            if (position == s.length()) {
                output.add(s);
                return;
            }

            char[] chars = s.toCharArray();

            if (Character.isLetter(chars[position])) {
                fillPermutations(output, s, position + 1);

                if (Character.isUpperCase(chars[position])) {
                    chars[position] = Character.toLowerCase(chars[position]);
                } else {
                    chars[position] = Character.toUpperCase(chars[position]);
                }
                fillPermutations(output, String.valueOf(chars), position + 1);

            } else {
                fillPermutations(output, s, position + 1);
            }
        }
    }
}
