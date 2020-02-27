package com.offer;


import java.util.Stack;

/**
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class O41 {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        //借助一个栈
        Stack<ListNode> stack = new Stack<>();
        ListNode remove = null;
        ListNode cur = pHead;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            if (!stack.isEmpty()) {
                if (stack.peek().val == cur.val) {
                    remove = stack.pop();
                    if (!stack.isEmpty()) {
                        stack.peek().next = null;
                    }
                } else if (remove == null || remove.val != cur.val) {
                    stack.peek().next = cur;
                    stack.push(cur);
                }
            } else {
                if (remove == null || remove.val != cur.val)
                    stack.push(cur);
            }
            cur = next;
        }
        pHead = null;
        while (!stack.isEmpty()) {
            pHead = stack.pop();
        }
        return pHead;
    }

    /**
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead==null ||pHead.next==null)
            return pHead;

        ListNode Head = new ListNode(0);
        Head.next = pHead; //将虚拟头结点与原链表串起来
        ListNode pre = Head; // pre指针指向当前确定不重复的那个节点
        ListNode last = pHead; //工作指针始终在pre的后边

        while (last!=null){
            if (last.next!=null && last.val == last.next.val){
                //找到最后一个相等的值节点
                while (last.next!=null && last.val == last.next.val){
                    last = last.next;
                }
                //last.next不和之前的节点相等
                last = last.next;
                //存在重复元素时不移动pre只是将pre与不重复的连接起来
                pre.next = last;
            }else {
                //如果当前节点与下一个节点不相等，分别移动pre和last
                pre = pre.next;
                last = last.next;
            }
        }
        return Head.next;
    }
}
