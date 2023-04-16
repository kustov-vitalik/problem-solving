package com.leetcode.problem.heap;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-words/">Problem description</a>
 */
public class Solved_Problem692TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(new String[] {"i","love","leetcode","i","love","coding"}, 2)); // ["i","love"]
        System.out.println(new Solution().topKFrequent(new String[] {"the","day","is","sunny","the","the","the","sunny","is","is"}, 4)); // ["the","is","sunny","day"]
    }

    static class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> countMap = new TreeMap<>();
            for (String word : words) {
                countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            }

            List<String> output = new ArrayList<>();
            Stream<Map.Entry<String,Integer>> sorted = countMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            AtomicInteger counter = new AtomicInteger(k);
            sorted.forEach(entry -> {
                if (counter.intValue() == 0) {
                    return;
                }
                output.add(entry.getKey());
                counter.decrementAndGet();
            });

            return output;
        }
    }
}
