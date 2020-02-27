package com.leetcode;

public class leetcode160 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode ha = headA;
        ListNode hb = headB;
        while (ha != hb) {
            ha=ha==null?headB:ha.next;
            hb=hb==null?headA:hb.next;
        }

        return ha;
    }
}
