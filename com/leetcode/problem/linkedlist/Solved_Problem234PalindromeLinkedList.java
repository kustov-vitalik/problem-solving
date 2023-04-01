package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

public class Solved_Problem234PalindromeLinkedList {

  public static void main(String[] args) {
    System.out.println(new Solution().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))) == true);
    System.out.println(new Solution().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2)))) == false);
  }

  static class Solution {
    public boolean isPalindrome(ListNode head) {
      if (head == null || head.next == null) {
        return true;
      }

      int size = size(head);
      ListNode suffix = head;
      int counter = 0;
      while (counter < size/2) {
        suffix = suffix.next;
        counter++;
      }

      ListNode reversed = reversePart(suffix);

      while (reversed != null) {
        if (reversed.val != head.val) {
          return false;
        }
        reversed = reversed.next;
        head = head.next;
      }

      return true;

    }

    public int size(ListNode node) {
      ListNode tmp = node;
      int size = 0;
      while (tmp != null) {
        tmp = tmp.next;
        size++;
      }

      return size;
    }

    public ListNode reversePart(ListNode node) {
      ListNode head = node;
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
