package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

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
