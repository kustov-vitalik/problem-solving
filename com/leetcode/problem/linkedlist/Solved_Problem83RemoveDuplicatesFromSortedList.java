package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list">Problem description</a>
 */
public class Solved_Problem83RemoveDuplicatesFromSortedList {

  public static void main(String[] args) {

    var list = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2)))));

    System.out.println(new Solved_Problem83RemoveDuplicatesFromSortedList().deleteDuplicates(list));
  }

  public ListNode deleteDuplicates(ListNode head) {

    ListNode ref = new ListNode(0, head);

    ListNode prev = ref;

    while (head != null && head.next != null) {
      ListNode next = head.next;

      if (head.val == next.val) {
        prev.next = next;
      } else {
        prev = head;
      }
      head = next;

    }

    return ref.next;

  }

}
