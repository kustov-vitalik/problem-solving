package net.projecteuler.problem;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import net.projecteuler.problem.lib.Lib;

public class Problem68Magic5gonRing {

  public static void main(String[] args) {

//    var numbers = List.of(1,2,3,4,5,6,7,8,9,10);
    var numbers = List.of(1,2,3,4,5,6);
    Map<Integer, Integer> map = new TreeMap<>();
    List<List<Integer>> lists = Lib.subsets(numbers).stream()
        .filter(set -> set.size() == 3)
        .peek(list -> {
          int sum = list.stream().mapToInt(value -> value).sum();
          if (map.containsKey(sum)) {
            map.put(sum, map.get(sum) + 1);
          } else {
            map.put(sum, 1);

          }

        })
//        .filter(list -> {
//          int sum = list.stream().mapToInt(i -> i).sum();
//          return map.get(sum) >= 3;
//        })
        .collect(Collectors.toList());

    System.out.println(lists);
    System.out.println(map);

  }

}
