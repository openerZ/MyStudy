package com.offer;

import java.util.HashSet;

/**
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class O46 {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 使用了额外空间
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        HashSet<ListNode> s = new HashSet<>();

        while (pHead != null) {
            if (s.contains(pHead)) {
                return pHead;
            } else {
                s.add(pHead);
            }
            pHead = pHead.next;

        }
        return null;
    }

    /**
     * 设置双指针,快指针和慢指针，，快指针一次走两步，慢指针一次走一步
     * 如果存在环，那么两指针必定相交于环内一点，此时将快指针重新指向头节点
     * 然后和慢指针一样一次只走一步，之后再次相交，就是环的入口点
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;

        ListNode p1 = pHead; //一次走一步
        ListNode p2 = pHead; //一次走两步

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) { //如果相交代表存在环
                p2 = pHead;
                while (p2 != null) {
                    if (p2 == p1) {
                        return p1;
                    }
                    p2 = p2.next;
                    p1 = p1.next;
                }
            }
        }
        return null;
    }

    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead, fast = pHead;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
