package com.leetcode.problem.arrays;

import java.util.Arrays;

public class Solved_Problem88MergeSortedArray {

  public static void main(String[] args) {
    var nums1 = new int[]{1, 2, 3, 0, 0, 0};
    var nums2 = new int[]{2, 5, 6};

    new Solution().merge(nums1, 3, nums2, 3);

    System.out.println(Arrays.toString(nums1)); // [1,2,2,3,5,6]
  }

  static class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {


      if (n == 0) {
        return;
      }

      if (m == 0) {
        for (int i = 0; i < nums1.length; i++) {
          nums1[i] = nums2[i];
        }
        return;
      }



      int pointer = nums1.length - 1;
      int mPointer = m - 1;
      int nPointer = n - 1;

      while (mPointer >= 0 && nPointer >= 0) {
        int mVal = nums1[mPointer];
        int nVal = nums2[nPointer];

        if (mVal >= nVal) {
          nums1[pointer] = mVal;
          mPointer--;
        } else {
          nums1[pointer] = nVal;
          nPointer--;
        }
        pointer--;
      }

      while (mPointer >= 0) {
        nums1[pointer] = nums1[mPointer];
        mPointer--;
        pointer--;
      }

      while (nPointer >= 0) {
        nums1[pointer] = nums2[nPointer];
        nPointer--;
        pointer--;
      }

    }
  }

}
