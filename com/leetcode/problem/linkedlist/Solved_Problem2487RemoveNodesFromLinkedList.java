package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

public class Solved_Problem2487RemoveNodesFromLinkedList {

  public static void main(String[] args) {
    var list1 = new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))));
    System.out.println(new Solution().removeNodes(list1));

    System.out.println(new Solution().removeNodes(new ListNode(1, new ListNode(1, new ListNode(1)))));


  }

  static class Solution {
    public ListNode removeNodes(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode reversed = reverse(head);
      head = reversed;

      ListNode response = new ListNode(Integer.MIN_VALUE);
      ListNode ref = response;
      while (head != null) {
        if (response.val <= head.val) {
          response.next = new ListNode(head.val);
          response = response.next;
        }
        head = head.next;
      }

      return reverse(ref.next);
    }

    private ListNode reverse(ListNode head) {
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
