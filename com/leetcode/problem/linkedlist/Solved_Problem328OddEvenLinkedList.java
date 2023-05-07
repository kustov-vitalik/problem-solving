package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/odd-even-linked-list/">Problem description</a>
 */
public class Solved_Problem328OddEvenLinkedList {
    public static void main(String[] args) {
        System.out.println(new Solution().oddEvenList(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    }

    private static class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode ref = head;

            ListNode even = null;
            ListNode odd = null;
            ListNode oddRef = null;

            int counter = 0;

            while (head != null) {

                if (counter % 2 == 0) {
                    if (even == null) {
                        even = head;
                    } else {
                        even.next = head;
                        even = even.next;
                    }
                } else {
                    if (odd == null) {
                        odd = head;
                        oddRef = odd;
                    } else {
                        odd.next = head;
                        odd = odd.next;
                    }
                }

                head = head.next;
                counter++;

            }

            even.next = oddRef;

            if (odd != null) {
                odd.next = null;
            }

            return ref;
        }
    }
}
