package com.leetcode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class leetcode61 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //本质上是将尾部向前数第K个元素作为头，原来的头接到原来的尾上
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null ||k==0)return head;
        ListNode pre = head;
        int count = 1;
        while (pre.next != null) {
            count++;
            pre = pre.next;
        }
        ListNode tail = pre; //末尾
        k = k % count;
        if (k==0) return head;
        int t=count-k;
        pre=head;
        while (t>1){
            pre=pre.next;
            t--;
        }
        ListNode nHead = pre.next;
        pre.next=null;
        tail.next=head;
        return nHead;
    }

}
