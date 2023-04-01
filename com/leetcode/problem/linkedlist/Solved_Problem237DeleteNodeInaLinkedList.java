package com.leetcode.problem.linkedlist;

import com.leetcode.common.ListNode;

public class Solved_Problem237DeleteNodeInaLinkedList {

  public static void main(String[] args) {
    var list1 = new ListNode(4, new ListNode(5));
    var list = new ListNode(1, new ListNode(2, new ListNode(3, list1)));

    new Solution().deleteNode(list1);
    System.out.println(list);
  }

  static class Solution {
    public void deleteNode(ListNode node) {
      node.val = node.next.val;
      node.next = node.next.next;
    }
  }

}
