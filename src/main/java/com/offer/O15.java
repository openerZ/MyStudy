package com.offer;

/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class O15 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head ==null) return null;
        if (k<=0) return null;
        ListNode cur = head;
        int t=0;
        while (cur!=null){
            t++;
            cur = cur.next;
        }
        int m = t-k+1;
        if (m<=0){
            return null;
        }
        while (head!=null && m>1){
            head = head.next;
            m--;
        }
        return head;

    }

    /**
     * 设置两个指针p1,p2
     * p1先移动正数的第k的位置
     * 然后p2在和p1一起移动，直到p1移动到链表尾，这时p2是倒数k的位置
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail1(ListNode head,int k) {
        if (head==null || k<=0){
            return null;
        }

        ListNode p1=head;
        while (p1!=null && k-->0){
            p1=p1.next;
        }

        if (k>0){
            return null;
        }
        ListNode p2=head;

        while (p1!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;

    }

}
