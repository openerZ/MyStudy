package com.leetcode;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 */
public class leetcode328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next==null) return head;
        ListNode jhead = head;
        ListNode ohead = head.next;
        ListNode cur = ohead.next;
        ohead.next=null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = jhead.next;
            jhead.next = cur;
            jhead =cur;
            cur = next;
            if (cur != null) {
                next = cur.next;
                cur.next = null;
                ohead.next = cur;
                ohead = cur;
                cur = next;
            }
        }
        return head;
    }

    public ListNode oddEvenList1(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        // head 为奇链表头结点，o 为奇链表尾节点
        ListNode o = head;
        // p 为偶链表头结点
        ListNode p = head.next;
        // e 为偶链表尾节点
        ListNode e = p;
        while (o.next != null && e.next != null) {
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        o.next = p;
        return head;
    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
