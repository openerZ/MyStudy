package com.leetcode;

import java.util.Stack;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class leetcode24 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 利用栈进行迭代
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;

        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while (head != null) {
            ListNode next = head.next;
            if (stack.isEmpty()) {
                stack.push(head);
            } else {
                head.next = stack.pop();
                p.next = head;
                p = p.next.next;
            }
            head = next;
        }
        while (!stack.isEmpty()) {
            p.next = stack.pop();
            p = p.next;
        }
        p.next = null;

        return dummy.next;

    }

    public ListNode swapPairs1(ListNode head) {
        if (head==null||head.next==null) return head;

        //存第二节点
        ListNode next = head.next;
        //第一个节点的next递归
        head.next = swapPairs1(next.next);
        //第二个节点的next为第一个节点
        next.next = head;
        return next;

    }
}
