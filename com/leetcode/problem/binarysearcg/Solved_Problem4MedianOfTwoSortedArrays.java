package com.leetcode.problem.binarysearcg;

public class Solved_Problem4MedianOfTwoSortedArrays {

  public static void main(String[] args) {
    System.out.println(new Solved_Problem4MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 3},new int[]{2})); // 2.0
    System.out.println(new Solved_Problem4MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2},new int[]{3, 4})); // 2.5
    System.out.println(new Solved_Problem4MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2, 3, 4},new int[]{2, 3})); // 2.5
    System.out.println(new Solved_Problem4MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2, 3, 4},new int[]{7})); // 3
    System.out.println(new Solved_Problem4MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{4,5},new int[]{1,2,3})); // 3
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int m = nums1.length;
    int n = nums2.length;

    int left = 0;
    int right = m;

    while (left <= right) {
      int midX = (left + right)/2;
      int midY = (m + n + 1) / 2 - midX;
      int valXLeft = midX == 0 ? Integer.MIN_VALUE : nums1[midX - 1];
      int valXRight = midX == m ? Integer.MAX_VALUE : nums1[midX];
      int valYLeft = midY == 0 ? Integer.MIN_VALUE : nums2[midY - 1];
      int valYRight = midY == n ? Integer.MAX_VALUE : nums2[midY];

      if (valYLeft <= valXRight && valXLeft <= valYRight) {
        if ((m + n) % 2 == 0) {
          return (Math.max(valXLeft, valYLeft) + Math.min(valXRight, valYRight)) / 2.0;
        } else {
          return Math.max(valXLeft, valYLeft);
        }
      } else if (valXLeft > valYRight) {
        right = midX - 1;
      } else {
        left = midX + 1;
      }
    }

    return 0;
  }

}
