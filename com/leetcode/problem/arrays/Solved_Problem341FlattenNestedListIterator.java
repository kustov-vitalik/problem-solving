package com.leetcode.problem.arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/flatten-nested-list-iterator/">Problem description</a>
 */
public class Solved_Problem341FlattenNestedListIterator {
    public static void main(String[] args) {

    }

    public class NestedIterator implements Iterator<Integer> {
        Iterator<Integer> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            List<Integer> list = new ArrayList<>();
            fillList(list, nestedList);
            iterator = list.iterator();
        }

        private void fillList(List<Integer> list, List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    list.add(nestedInteger.getInteger());
                } else {
                    fillList(list, nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }

    interface NestedInteger {
        boolean isInteger();
        Integer getInteger();
        List<NestedInteger> getList();
    }
}
