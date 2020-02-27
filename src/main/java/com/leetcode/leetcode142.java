package com.leetcode;

public class leetcode142 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode quick = head;
        boolean flag = false;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                flag =true;
                break;
            }
        }
        if (flag){
            quick = head;
            while (quick!=slow){
                quick=quick.next;
                slow = slow.next;
            }
            return quick;
        }else {
            return null;
        }
    }
}
