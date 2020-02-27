package com.leetcode;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class leetcode23 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        return merge(lists,0,lists.length-1);

    }

    private ListNode merge(ListNode[] lists,int left,int right){
        if (left<right){
            int mid = left+(right-left)/2;
            ListNode pl = merge(lists, left, mid);
            ListNode pr = merge(lists, mid + 1, right);
            ListNode listNode = mergeList(pl, pr);
            return listNode;
        }

        return lists[left];

    }

    private ListNode mergeList(ListNode left,ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode p= dummy;
        while (left!=null && right!=null){
            if (left.val<right.val){
                p.next = left;
                left = left.next;
            }else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        if (left!=null){
            p.next = left;
        }
        if (right!=null){
            p.next= right;
        }
        return dummy.next;
    }
}
