package com.leetcode.problem.trees;

import com.leetcode.common.ListNode;
import com.leetcode.common.TreeNode;

public class Solved_Problem109ConvertSortedListToBinarySearchTree {

  public static void main(String[] args) {
    ListNode listNode = new ListNode(-10,
        new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
    System.out.println(new Solution().sortedListToBST(listNode));
  }

  static class Solution {
    public TreeNode sortedListToBST(ListNode head) {
      if (head == null) {
        return null;
      }

      if (head.next == null) {
        return new TreeNode(head.val);
      }

      ListNode ref = head;
      ListNode slow = head;
      ListNode fast = head;
      ListNode prev = null;
      while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
      }

      prev.next = null;
      ListNode left = ref;
      ListNode right = slow.next;
      slow.next = null;
      ListNode middle = slow;

//      System.out.println(left);
//      System.out.println(middle);
//      System.out.println(right);

      TreeNode root = new TreeNode(middle.val);
      root.left = sortedListToBST(left);
      root.right = sortedListToBST(right);

      return root;
    }

  }

}
