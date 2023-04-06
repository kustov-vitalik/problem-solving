package com.leetcode.problem.binarysearcg;

/**
 * <a href="https://leetcode.com/problems/find-the-distance-value-between-two-arrays/">Problem description</a>
 */
public class Solved_Problem1385FindTheValueBetweenTwoArrays {

  public static void main(String[] args) {
    System.out.println(new Solution().findTheDistanceValue(new int[] {4,5,8}, new int[] {10,9,1,8}, 2)); // 2
    System.out.println(new Solution().findTheDistanceValue(new int[] {1,4,2,3}, new int[] {-4,-3,6,10,20,30}, 3)); // 2
    System.out.println(new Solution().findTheDistanceValue(new int[] {2,1,100,3}, new int[] {-5,-2,10,-3,7}, 6)); // 1
  }

  static class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

      // bruteforce
      int counter = 0;
      boolean outside;
      for (int num : arr1) {
        outside = true;

        for (int num2 : arr2) {
          if (Math.abs(num - num2) <= d) {
            outside = false;
            break;
          }
        }

        if (outside) {
          counter++;
        }
      }

      return counter;
    }
  }

}
