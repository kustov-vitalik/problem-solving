package com.leetcode.problem.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/keys-and-rooms/">Problem description</a>
 */
public class Solved_Problem841KeysAndRooms {
    public static void main(String[] args) {
        System.out.println(new Solution().canVisitAllRooms(List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of()
        ))); // true
    }

    private static class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {

            boolean[] visited = new boolean[rooms.size()];
            Queue<Integer> queue = new LinkedList<>();
            visited[0] = true;
            queue.offer(0);

            while (!queue.isEmpty()) {
                int size = queue.size();

                while (size-- > 0) {
                    int idx = queue.poll();
                    visited[idx] = true;

                    for (Integer nextIdx : rooms.get(idx)) {
                        if (!visited[nextIdx]) {
                            visited[nextIdx] = true;
                            queue.offer(nextIdx);
                        }
                    }
                }
            }

            for (boolean b : visited) {
                if (!b) {
                    return false;
                }
            }

            return true;
        }
    }
}
