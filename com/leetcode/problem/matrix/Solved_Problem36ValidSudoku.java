package com.leetcode.problem.matrix;

/**
 * <a href="https://leetcode.com/problems/valid-sudoku/">Problem description</a>
 */
public class Solved_Problem36ValidSudoku {

  public static void main(String[] args) {
    System.out.println(new Solution().isValidSudoku(new char[][]{
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
    })); // true

    System.out.println(new Solution().isValidSudoku(new char[][]{
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '8', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
    })); // false

    System.out.println(new Solution().isValidSudoku(new char[][]{
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '1', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
    })); // false

    System.out.println(new Solution().isValidSudoku(new char[][]{
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '4', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
    })); // false
  }

  static class Solution {
    public boolean isValidSudoku(char[][] board) {

      for (int i = 0; i < board.length; i++) {
        if (!validRow(board[i])) {
          return false;
        }
      }

      char[] col = new char[board.length];
      for (int i = 0; i < board.length; i+=3) {
        for (int j = 0; j < board.length; j+=3) {

          for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
              col[3*k + l] = board[i + k][j + l];
            }
          }
          if (!validRow(col)) {
            return false;
          }

        }
      }

      for (int i = 0; i < board.length; i++) {

        for (int j = 0; j < board[i].length; j++) {
          col[j] = board[j][i];
        }

        if (!validRow(col)) {
          return false;
        }
      }


      return true;
    }

    private boolean validRow(char[] chars) {
      int[] map = new int[9];
      for (char aChar : chars) {
        if (aChar != '.') {
          map[Integer.parseInt(String.valueOf(aChar)) - 1] ++;
        }
      }

      for (var i : map) {
        if (i > 1) {
          return false;
        }
      }
      return true;
    }
  }
}
