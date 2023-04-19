package com.leetcode.problem.graph;

/**
 * <a href="https://leetcode.com/problems/word-search/">Problem description</a>
 */
public class Problem79WordSearch {
    public static void main(String[] args) {

        System.out.println(new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED")); // true

        System.out.println(new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE")); // true

        System.out.println(new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCESEEEFS")); // true

        System.out.println(new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB")); // false

        System.out.println(new Solution().exist(new char[][]{
                {'a', 'b'},
                {'c', 'd'},
        }, "cdba")); // true
    }

    private static class Solution {
        private static final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public boolean exist(char[][] board, String word) {
            for (var i = 0; i < board.length; i++) {
                for (var j = 0; j < board[0].length; j++) {
                    if ((board[i][j] == word.charAt(0)) && exist(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
            return false;
        }

        // backtracking template: for each choice: choose-explore-unchoose
        private boolean exist(char[][] board, int i, int j, int count, String word) {
            if (count == word.length())
                return true;
            if (i == -1 || i == board.length || j == -1 || j == board[0].length || board[i][j] != word.charAt(count))
                return false;

            // choose
            var temp = board[i][j];
            board[i][j] = ' ';
            var found = false;

            // explore
            for (var dir : DIRS) {
                if (exist(board, i + dir[0], j + dir[1], count + 1, word)) {
                    found = true;
                    break;
                }
            }

            // unchoose
            board[i][j] = temp;
            return found;
        }
    }
}
