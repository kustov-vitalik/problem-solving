package com.leetcode.problem.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solved_Problem49GroupAnagrams {

  public static void main(String[] args) {

    System.out.println(new Solution().groupAnagrams(
        new String[]{"eat","tea","tan","ate","nat","bat"})); // [["bat"],["nat","tan"],["ate","eat","tea"]]
    System.out.println(new Solution().groupAnagrams(new String[]{""})); // [[""]]
    System.out.println(new Solution().groupAnagrams(new String[]{"a"})); // [["a"]]


  }

  static class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      if (strs.length == 0) {
        return new ArrayList<>();
      }
      if (strs.length == 1) {
        return List.of(List.of(strs[0]));
      }

      Map<Map<Character, Integer>,List<String>> map = new HashMap<>();

      for (String str : strs) {
        Map<Character, Integer> characterMap = new HashMap<>();

        for (char c : str.toCharArray()) {
          if (characterMap.containsKey(c)) {
            characterMap.put(c, characterMap.get(c) + 1);
          } else {
            characterMap.put(c, 1);
          }
        }

        if (map.containsKey(characterMap)) {
          map.get(characterMap).add(str);
        } else {
          List<String> list = new ArrayList<>();
          list.add(str);
          map.put(characterMap, list);
        }
      }

      return new ArrayList<>(map.values());
    }
  }

}
