package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

public class Solved_Problem24SwapNodesInPairs {

  public static void main(String[] args) {
    System.out.println(new Solved_Problem24SwapNodesInPairs().swapPairs(new ListNode(1,
        new ListNode(2, new ListNode(3, new ListNode(4)))))); // 2->1->4->3

    System.out.println(new Solved_Problem24SwapNodesInPairs().swapPairs(null)); // null
    System.out.println(new Solved_Problem24SwapNodesInPairs().swapPairs(new ListNode(1))); // 1
  }

  public ListNode swapPairs(ListNode head) {
    if (head == null) {
      return null;
    }

    if (head.next == null) {
      return head;
    }

    ListNode prev = new ListNode(0, head);

    ListNode next = head.next; // 2
    ListNode ref = next;
    prev.next = next;
    ListNode nextNext = next.next; // 3
    head.next = nextNext;
    next.next = head;
    prev = head;
    head = nextNext;

    while (head != null && head.next != null) {
      next = head.next; // 2
      prev.next = next;
      nextNext = next.next; // 3
      head.next = nextNext;
      next.next = head;
      prev = head;
      head = nextNext;
    }

    return ref;
  }

}
