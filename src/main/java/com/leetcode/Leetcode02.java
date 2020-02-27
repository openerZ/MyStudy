package com.leetcode;


/**
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
public class Leetcode02 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode n = root;
        int v4=0;
        while (l1!=null || l2!=null || v4!=0){
            int v1=0;
            int v2=0;
            int v3=0;
            if (l1!=null){
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                v2 = l2.val;
                l2=l2.next;
            }
            v3 = (v1+v2+v4)%10;
            n.next = new ListNode(v3);
            n=n.next;
            v4 = (v1+v2+v4)/10;

        }
        return root.next;
    }

}
