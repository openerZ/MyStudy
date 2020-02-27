package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class leetcode86 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode partition(ListNode head, int x) {
       ListNode head1 = new ListNode(-1);
       ListNode samll = head1;
       ListNode head2 = new ListNode(-1);
       ListNode big= head2;

       ListNode cur= head;
       while (cur!=null){
           if (cur.val<x){
               samll.next =cur;
               cur = cur.next;
               samll =samll.next;
               samll.next =null;
           }else {
               big.next = cur;
               cur=cur.next;
               big =big.next;
               big.next =null;
           }
       }
       samll.next = head2.next;
       return head1.next;
    }
    public ListNode partition1(ListNode head, int x) {
        ListNode cur = head;
        List<Integer> small = new ArrayList<>();
        List<Integer> big = new ArrayList<>();
        while (cur!=null){
            if (cur.val<x){
                small.add(cur.val);
            }else {
                big.add(cur.val);
            }
            cur=cur.next;
        }
        int k=0;
        cur=head;
        while (k<small.size()){
            cur.val = small.get(k++);
            cur =cur.next;
        }
        k=0;
        while (k<big.size()){
            cur.val = big.get(k++);
            cur = cur.next;
        }
        return head;
    }
}
