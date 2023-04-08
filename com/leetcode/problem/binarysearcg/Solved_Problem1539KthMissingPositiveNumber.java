package com.leetcode.problem.binarysearcg;

/**
 * <a href="https://leetcode.com/problems/kth-missing-positive-number/">Problem description</a>
 */
public class Solved_Problem1539KthMissingPositiveNumber {

  public static void main(String[] args) {
    System.out.println(new Solution().findKthPositive(new int[] {2,3,4,7,11}, 5)); // 9
    System.out.println(new Solution().findKthPositive(new int[] {1,2,3,4}, 2)); // 6
    System.out.println(new Solution().findKthPositive(new int[] {1,2,3,4,6}, 2)); // 7
    System.out.println(new Solution().findKthPositive(new int[] {1,3}, 1)); // 2
  }

  static class Solution {
    public int findKthPositive(int[] arr, int k) {
      int left = 0;
      int right = arr.length - 1;
      int mid;
      int diff;
      while (left <= right) {
        mid = (left + right) >>> 1;
        diff = arr[mid] - (mid + 1);

        if (mid + 1 < arr.length && (diff < k && arr[mid+1] - (mid + 2) > k)) {
            right = mid;
            break;
        }


        if (diff < k) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      System.out.println("Right:" + right);
      return k + right + 1;
    }
  }
}
