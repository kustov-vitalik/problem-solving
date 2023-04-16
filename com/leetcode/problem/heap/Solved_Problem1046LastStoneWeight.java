package com.leetcode.problem.heap;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/last-stone-weight/">Problem description</a>
 */
public class Solved_Problem1046LastStoneWeight {
    public static void main(String[] args) {
        System.out.println(new Solution().lastStoneWeight(new int[] {2,7,4,1,8,1}));
    }

    static class Solution {
        public int lastStoneWeight(int[] stones) {

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
            for (int stone : stones) {
                priorityQueue.offer(stone);
            }

            while (priorityQueue.size() > 1) {
                int a = priorityQueue.poll();
                int b = priorityQueue.poll();
                priorityQueue.offer(Math.abs(a - b));
            }

            return priorityQueue.poll();
        }
    }
}
