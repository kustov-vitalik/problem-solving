package com.leetcode.problem.arrays;

public class Problem42TrappingRainWater {

  public static void main(String[] args) {

    System.out.println(new Problem42TrappingRainWater().trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1})); // 6
    System.out.println(new Problem42TrappingRainWater().trap(new int[] {4,2,0,3,2,5})); // 9

  }


  public int trap(int[] height) {

    // if < than 2 max -> 0
    int numberOfMaximums = 0;
    for (int i = 1; i < height.length - 1; i++) {
      // [0,0,1,0]
      // [0,1,1,0]
      // [0,0,0,0]
    }



    return 0;
  }



}
