package com.leetcode;

public class leetcode206 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode dummy = new ListNode(-1);

        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next =cur;
            cur= next;
        }
        return dummy.next;
    }

    public ListNode reverseList1(ListNode head) {
        if (head==null ||head.next==null) return head;

        ListNode next = head.next;
        head.next=null;
        ListNode listNode = reverseList(next);
        next.next = head;
        return listNode;

    }
}
