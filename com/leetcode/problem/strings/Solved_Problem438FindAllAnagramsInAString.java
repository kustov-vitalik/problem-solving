package com.leetcode.problem.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/">Problem description</a>
 */
public class Solved_Problem438FindAllAnagramsInAString {
    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new Solution().findAnagrams("abab", "ab"));
    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            if (p.length() > s.length()) {
                return new ArrayList<>();
            }

            int[] charMap = new int[26];
            for (char c : p.toCharArray()) {
                charMap[c - 'a']++;
            }

            char[] chars = s.toCharArray();
            int[] charMapWindow = new int[26];
            for (int i = 0; i < p.length(); i++) {
                charMapWindow[chars[i] - 'a']++;
            }


            List<Integer> output = new ArrayList<>();

            int left = 0;
            int right = p.length();
            while (right < s.length()) {

                if (Arrays.equals(charMap, charMapWindow)) {
                    output.add(left);
                }

                charMapWindow[chars[left] - 'a']--;
                charMapWindow[chars[right] - 'a']++;
                left++;
                right++;
            }

            if (Arrays.equals(charMap, charMapWindow)) {
                output.add(left);
            }

            return output;
        }
    }
}
