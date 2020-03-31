package com.leetcode;

import java.util.Stack;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 */
public class leetcode92 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode pre = dummy;

        int k=0;
        while (pre!=null){
            if (k==m-1){
                ListNode p =pre;
                while (p.next!=null && k<n){
                    p=p.next;
                    k++;
                    stack.push(p);
                }
                ListNode next = p.next;
                while (!stack.isEmpty()){
                    pre.next=stack.pop();
                    pre=pre.next;
                }
                pre.next=next;
                break;
            }
            pre =pre.next;
            k++;
        }
        return dummy.next;
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode pre = dummy;
        int k=0;
        while (pre!=null){
            if (k==m-1){
                ListNode p =pre.next;
                //翻转段的尾
                ListNode q =pre.next;
                ListNode temp=pre;
                temp.next=null;
                while (p!=null && k<n){
                    ListNode next = p.next;
                    p.next = temp.next;
                    temp.next=p;
                    p=next;
                    k++;
                }
                q.next=p;
                break;
            }
            pre =pre.next;
            k++;
        }
        return dummy.next;
    }
}
