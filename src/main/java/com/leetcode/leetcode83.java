package com.leetcode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class leetcode83 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head==null) return head;
        if (head.next!=null && head.val==head.next.val){
            while (head.next!=null && head.val==head.next.val){
                head = head.next;
            }
            //去重只保留一个
            return deleteDuplicates(head);
        }else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy= new ListNode(-1);
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur!=null){
            if (cur.next!=null && cur.val ==cur.next.val){
                while (cur.next!=null && cur.val ==cur.next.val){
                    cur = cur.next;
                }
            }else {
                pre.next = cur;
                cur =cur.next;
                pre = pre.next;
                pre.next=null;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) return head;
        if (head.val ==head.next.val){
            head = deleteDuplicates(head.next);
        }else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}
