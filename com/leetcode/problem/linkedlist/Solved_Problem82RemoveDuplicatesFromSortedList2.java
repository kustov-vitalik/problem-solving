package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

public class Solved_Problem82RemoveDuplicatesFromSortedList2 {

  public static void main(String[] args) {
    var list = new ListNode(1, new ListNode(2,
        new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));

    System.out.println(
        new Solved_Problem82RemoveDuplicatesFromSortedList2().deleteDuplicates(list)); // [1->2->5]
    System.out.println(new Solved_Problem82RemoveDuplicatesFromSortedList2().deleteDuplicates(
        new ListNode(1, new ListNode(1))
    )); // []
  }

  public ListNode deleteDuplicates(ListNode head) {

    ListNode ref = new ListNode(0, head);

    ListNode prev = ref;

    int valueHolder = Integer.MAX_VALUE;

    while (head != null) {
      ListNode next = head.next;

      if (next != null && head.val == next.val || head.val == valueHolder) {
        valueHolder = head.val;
        prev.next = next;
      } else {
        prev = head;
      }

      head = next;
    }

    return ref.next;

  }

}
