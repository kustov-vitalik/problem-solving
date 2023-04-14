package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle/">Problem description</a>
 */
public class Solved_Problem141LinkedListCycle {

    public static void main(String[] args) {

    }

    static public class Solution {
        public boolean hasCycle(ListNode head) {

            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;

                if (slow == fast) {
                    return true;
                }
            }

            return false;

        }
    }

}
