package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/">Problem description</a>
 */
public class Solved_Problem206ReverseLinkedList {


  static class Solution {
    public ListNode reverseList(ListNode head) {
      ListNode prev = null;
      while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
      }
      return prev;
    }
  }
}
