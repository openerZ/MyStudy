package com.offer;

/**
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class O36 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 因为是单链表：意味着存在着某一点被连个链表同时指向，指向就是一条重合的链表，
     * 也可以认为是一条从重合点额单链表
     * 在未重合前俩个链表的长度可能不同
     * 如果能使长链表移动到的位置到尾的位置的长度与短链表的长度相同就可以
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null && pHead2 == null) {
            return null;
        } else if (pHead1 == null) {
            return pHead1;
        } else if (pHead2 == null) {
            return pHead2;
        } else if (pHead1 == pHead2) {
            return pHead1;
        } else {
            int p1 = ListNodeLength(pHead1);
            int p2 = ListNodeLength(pHead2);
            ListNode longest = pHead1;
            ListNode shortest = pHead2;

            if (p1 < p2) {
                longest = pHead2;
                shortest = pHead1;
            }

            for (int i = 0; i < Math.abs(p1 - p2); i++) {
                longest = longest.next;
            }

            while (longest != null) {
                if (longest == shortest) {
                    return longest;
                }
                longest = longest.next;
                shortest = shortest.next;
            }

            return null;

        }

    }

    private int ListNodeLength(ListNode node) {

        int length = 0;
        if (node == null) return length;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1!=p2){
            p1 = (p1==null?pHead2:p1.next);
            p2 = (p2==null?pHead1:p2.next);
        }

        return p1;


    }

}
