package com.leetcode.problem.heap;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/">Problem description</a>
 */
public class Solved_Problem347TopKFrequentElements {
    public static void main(String[] args) {

    }

    private static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> countMap = new TreeMap<>();
            for (var num : nums) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }

            List<Integer> output = new ArrayList<>();
            Stream<Map.Entry<Integer,Integer>> sorted = countMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            AtomicInteger counter = new AtomicInteger(k);
            sorted.forEach(entry -> {
                if (counter.intValue() == 0) {
                    return;
                }
                output.add(entry.getKey());
                counter.decrementAndGet();
            });

            return output.stream().mapToInt(i -> i).toArray();
        }
    }
}
