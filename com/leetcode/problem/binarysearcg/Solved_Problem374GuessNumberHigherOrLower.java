package com.leetcode.problem.binarysearcg;

public class Solved_Problem374GuessNumberHigherOrLower {

  public static void main(String[] args) {
    System.out.println(new Solution(3).guessNumber(7)); // 3
    System.out.println(new Solution(20).guessNumber(40)); // 20
    System.out.println(new Solution(2).guessNumber(2)); // 20
  }

  static class Solution {

    int pickedNum;

    public Solution(int pickedNum) {
      this.pickedNum = pickedNum;
    }

    public int guessNumber(int n) {
      int lo = 1;
      int hi = n;

      while (lo <= hi) {
        int question = (lo + hi) >>> 1;
        int answer = guess(question);

        if(answer == 0) {
          return question;
        } else if (answer == 1) { // q < a
          lo = question + 1;
        } else { // q > a
          hi = question;
        }
      }

      return 1;
    }

    int guess(int num) {
      var res = Integer.compare(pickedNum, num);
      System.out.println("Q: " + num + ", A: " + res);
      return res;
    }
  }

}
