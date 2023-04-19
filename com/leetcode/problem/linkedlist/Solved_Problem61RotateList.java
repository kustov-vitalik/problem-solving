package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/rotate-list/">Problem description</a>
 */
public class Solved_Problem61RotateList {
    public static void main(String[] args) {
        System.out.println(new Solution().rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 7));
        System.out.println(new Solution().rotateRight(new ListNode(1), 5));
        System.out.println(new Solution().rotateRight(new ListNode(1, new ListNode(2)), 5));
    }

    private static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }

            int len = len(head);
            if (len == 1) {
                return head;
            }
            k = k % len;
            if (k == 0) {
                return head;
            }

            ListNode reversed = reverse(head);
            ListNode ref = reversed;
            ListNode prev = null;
            while (k > 0) {
                k--;
                prev = reversed;
                reversed = reversed.next;
            }
            prev.next = null;

            return append(reverse(ref), reverse(reversed));
        }

        private int len(ListNode node) {
            int len = 0;
            while (node != null) {
                node = node.next;
                len++;
            }
            return len;
        }

        private ListNode reverse(ListNode node) {
            ListNode prev = null;
            while (node != null) {
                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }
            return prev;
        }

        private ListNode append(ListNode l1, ListNode l2) {
            ListNode ref = l1;

            while (l1.next != null) {
                l1 = l1.next;
            }

            l1.next = l2;

            return ref;
        }
    }
}
