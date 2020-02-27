package com.offer;

/**
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 *
 */
public class O16 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }

    /**
     * 迭代
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode p1=list1;
        ListNode p2=list2;

        ListNode root = new ListNode(-1);
        ListNode nlist = root;
        while (p1!=null && p2!=null){
            if (p1.val>p2.val){
                nlist.next=p2;
                p2=p2.next;
            }else {
                nlist.next = p1;
                p1=p1.next;
            }
            nlist =nlist.next;
        }
        if(p1!=null){
            nlist.next = p1;
        }
        if (p2!=null){
            nlist.next = p2;
        }
        return root.next;
    }

    //递归
    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val <= list2.val) {
            list1.next = Merge1(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge1(list1, list2.next);
            return list2;
        }
    }
}
