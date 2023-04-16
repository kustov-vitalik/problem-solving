package com.leetcode.problem.strings;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/bulls-and-cows/">Problem description</a>
 */
public class Solved_Problem299BullsAndCows {
    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1807", "7810"));
    }

    static class Solution {
        public String getHint(String secret, String guess) {
            int bulls = 0;
            int cows = 0;

            char[] secretChars = secret.toCharArray();
            char[] guessChars = guess.toCharArray();

            int[] secretCharMap = new int[10];
            int[] guessCharMap = new int[10];

            for (int i = 0; i < secretChars.length; i++) {
                if (secretChars[i] == guessChars[i]) {
                    bulls++;
                } else {
                    secretCharMap[secretChars[i] - '0']++;
                    guessCharMap[guessChars[i] - '0']++;
                }
            }

            for (int i = 0; i < secretCharMap.length; i++) {
                cows += Math.min(secretCharMap[i], guessCharMap[i]);
            }

            return bulls + "A" + cows + "B";
        }
    }
}
