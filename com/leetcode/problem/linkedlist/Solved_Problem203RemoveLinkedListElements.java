package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

public class Solved_Problem203RemoveLinkedListElements {

  public static void main(String[] args) {
    var linkedList = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));

    System.out.println(new Solved_Problem203RemoveLinkedListElements().removeElements(linkedList, 6));

  }

  public ListNode removeElements(ListNode head, int val) {

    ListNode headRef = new ListNode(1, head);

    ListNode prev = headRef;

    while (head != null) {

      ListNode nextNode = head.next;

      if (head.val == val) {
        prev.next = nextNode;
      } else {
        prev = head;
      }

      head = nextNode;
    }

    return headRef.next;

  }

}
