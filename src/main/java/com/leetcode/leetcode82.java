package com.leetcode;

import java.util.Stack;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class leetcode82 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre;
        ListNode cur = fakeHead;

        while (cur != null) {
            pre = cur;
            cur = cur.next;
            while (cur != null && cur.next != null && cur.val == cur.next.val) {
                int val = cur.val;
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }
                pre.next = cur;
            }
        }
        return fakeHead.next;
    }

    /**
     * 采用递归
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return head;
        if (head.next!=null && head.val==head.next.val){
            while (head.next!=null&&head.val==head.next.val){
                head =head.next;
            }
            //去除重复，head.next为不重复的
            return deleteDuplicates(head.next);
        }else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode pre=dummy;
        ListNode cur = head;
        while (cur!=null){
            if (cur.next!=null && cur.val == cur.next.val){
                while (cur.next!=null && cur.val==cur.next.val){
                    cur =cur.next;
                }
                cur=cur.next;
            }else {
                pre.next = cur;
                cur=cur.next;
                pre = pre.next;
                pre.next =null;
            }
        }
        return dummy.next;
    }
}
