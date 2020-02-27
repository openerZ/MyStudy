package com.leetcode;


/**
 *给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 */
public class leetcode19 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 设连个指针p1,p2，p1先走k歩，然后p1,p2同时走，一直到p1==null
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head ==null) return null;
        ListNode p1 = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p2 = dummy;

        int index=0;
        while (p1!=null){
            if (index>=n){
                p2=p2.next;
            }
            index++;
            p1 = p1.next;
        }
        //此时p2在被删除节点的前一个
        if (p2!=null && p2.next!=null){
            ListNode remove = p2.next;
            p2.next = remove.next;
            remove.next=null;
        }
        return dummy.next;
    }
}
