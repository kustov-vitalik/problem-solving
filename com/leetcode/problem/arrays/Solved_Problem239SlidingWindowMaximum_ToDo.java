package com.leetcode.problem.arrays;

import java.util.Arrays;

// better use Deque (store indecies)
public class Solved_Problem239SlidingWindowMaximum_ToDo {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3))); // [3,3,5,5,6,7]
    System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[] {7,2,4}, 2))); // [7,4]
  }

  static class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

      int upCounter = 0;
      int downCounter = 0;

      for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] < nums[i + 1]) {
          upCounter++;
        } else {
          downCounter++;
        }
      }

      if (downCounter > upCounter) {
       swap(nums);
        int[] window = getMaxSlidingWindow(nums, k);
        swap(window);
        return window;

      } else {
        return getMaxSlidingWindow(nums, k);
      }
    }

    private void swap(int[] array) {
      int left = 0;
      int right = array.length - 1;

      while (left < right) {

        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;

        left++;
        right--;
      }
    }

    public int[] getMaxSlidingWindow(int[] nums, int k) {
      if (nums.length == 1) {
        return nums;
      }

      if(k == 1) {
        return nums;
      }

      if (k >= nums.length) {
        return new int[] {Arrays.stream(nums).max().getAsInt()};
      }


      int[] maxSlidingWindow = new int[nums.length - k + 1];

      int pointer = 0;

      int left = 0;
      int next = 0;

      while (pointer + k <= nums.length) {
        if (pointer == 0) {

          int max = Integer.MIN_VALUE;
          for (int i = 0; i < k; i++) {
            max = Math.max(nums[i], max);
          }

          maxSlidingWindow[pointer] = max;

        } else {

          int prevMax = maxSlidingWindow[pointer - 1];
          if (next >= prevMax) {
            maxSlidingWindow[pointer] = next;

          } else {

            if (left == prevMax) {
              // calc max
              int max = Integer.MIN_VALUE;
              for (int i = pointer; i < pointer + k; i++) {
                max = Math.max(nums[i], max);
              }

              maxSlidingWindow[pointer] = max;
            } else {
              maxSlidingWindow[pointer] = prevMax;
            }

          }

        }


        left = nums[pointer];
        if (pointer + k == nums.length) {
          next = Integer.MIN_VALUE;
        } else {
          next = nums[pointer + k];
        }

        pointer++;
      }

      return maxSlidingWindow;
    }
  }

}
