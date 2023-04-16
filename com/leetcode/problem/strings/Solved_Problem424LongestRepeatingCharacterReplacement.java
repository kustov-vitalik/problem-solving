package com.leetcode.problem.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-repeating-character-replacement/">Problem description</a>
 */
public class Solved_Problem424LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(new Solution().characterReplacement("ABAB", 2)); // 4
        System.out.println(new Solution().characterReplacement("AABABBA", 1)); // 4
        System.out.println(new Solution().characterReplacement("ABAA", 0)); // 2
        System.out.println(new Solution().characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4)); // 7
        System.out.println(new Solution().characterReplacement("EOEMQLLQTRQDDCOERARHGAAARRBKCCMFTDAQOLOKARBIJBISTGNKBQGKKTALSQNFSABASNOPBMMGDIOETPTDICRBOMBAAHINTFLH", 7)); // 11
    }

    static class Solution {
        public int characterReplacement(String s, int k) {

            Map<Character, Integer> charsWindow = new HashMap<>();

            int left = 0;
            int right = 0;
            int max = Integer.MIN_VALUE;

            while (right < s.length()) {
                charsWindow.put(s.charAt(right), charsWindow.getOrDefault(s.charAt(right), 0) + 1);
                right++;

                int windowSum = 0;
                int windowMax = Integer.MIN_VALUE;
                for (Integer value : charsWindow.values()) {
                    windowSum += value;
                    windowMax = Math.max(windowMax, value);
                }

                if (windowSum - windowMax <= k) {
                    max = Math.max(max, windowSum);
                } else {
                    int count = charsWindow.get(s.charAt(left));
                    if (count == 1) {
                        charsWindow.remove(s.charAt(left));
                    } else {
                        charsWindow.put(s.charAt(left), count - 1);
                    }
                    left++;
                }

//                System.out.println(charsWindow);
            }

            return max;
        }
    }
}
