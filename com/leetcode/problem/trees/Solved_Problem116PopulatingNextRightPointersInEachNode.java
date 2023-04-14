package com.leetcode.problem.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">Problem description</a>
 */
public class Solved_Problem116PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {

    }



    static class Solution {
        public Node connect(Node root) {
            Node ref = root;

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();

                Node prev = null;
                Node current = null;

                for (int i = 0; i < size; i++) {
                    current = queue.poll();
                    if (current != null) {
                        current.next = null;

                        if (prev != null) {
                            prev.next = current;
                        }

                        if (current.left != null) {
                            queue.offer(current.left);
                        }
                        if (current.right != null) {
                            queue.offer(current.right);
                        }

                        prev = current;
                    }
                }


            }

            return ref;
        }

    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
