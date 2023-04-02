package com.leetcode.problem.strings;

import java.util.HashMap;
import java.util.Map;

public class Solved_Problem205IsomorphicStrings {

  public static void main(String[] args) {
    System.out.println(new Solution().isIsomorphic("egg", "add")); // true
    System.out.println(new Solution().isIsomorphic("foo", "bar")); // false
    System.out.println(new Solution().isIsomorphic("paper", "title")); // true
    System.out.println(new Solution().isIsomorphic("bbbaaaba", "aaabbbba")); // false
  }

  static class Solution {
    public boolean isIsomorphic(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }

      Map<Character, Character> map = new HashMap<>();

      int pointer = 0;
      while (pointer < s.length()) {

        Character sChar = s.charAt(pointer);
        Character tChar = t.charAt(pointer);

        if (map.containsKey(sChar)) {
          Character prevVal = map.get(sChar);
          if (!prevVal.equals(tChar)) {
            return false;
          }
        } else {
          if (map.containsValue(tChar)) {
            return false;
          }

          map.put(sChar, tChar);
        }

        pointer++;
      }

      return true;
    }
  }

}
