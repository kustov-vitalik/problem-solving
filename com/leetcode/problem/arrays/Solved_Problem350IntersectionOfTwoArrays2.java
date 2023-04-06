package com.leetcode.problem.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/intersection-of-two-arrays-ii/">Problem description</a>
 */
public class Solved_Problem350IntersectionOfTwoArrays2 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().intersect(new int[] {1,2,2,1}, new int[] {2,2}))); // [2,2]
  }

  static class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

      Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums1) {
        if (map.containsKey(num)) {
          map.put(num, map.get(num) + 1);
        } else {
          map.put(num, 1);
        }
      }

      List<Integer> list = new ArrayList<>();
      for (int num : nums2) {
        if (map.containsKey(num)) {
          list.add(num);

          int count = map.get(num);
          if (count == 1) {
            map.remove(num);
          } else {
            map.put(num, count-1);
          }
        }
      }

      return list.stream().mapToInt(i -> i).toArray();
    }
  }

}
