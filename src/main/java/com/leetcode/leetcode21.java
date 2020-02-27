package com.leetcode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class leetcode21 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null && l2==null) return null;
        if (l1==null) return l2;
        if (l2==null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode nl = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1!=null && p2!=null){
            if (p1.val>p2.val){
                nl.next = p2;
                p2 = p2.next;
            }else {
                nl.next = p1;
                p1 = p1.next;
            }
            nl = nl.next;
        }
        if (p1!=null){
            nl.next = p1;
        }
        if (p2!=null){
            nl.next = p2;
        }
        return dummy.next;
    }
}
