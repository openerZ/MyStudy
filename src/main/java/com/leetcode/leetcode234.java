package com.leetcode;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 */
public class leetcode234 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode quick = head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        while (quick != null && quick.next != null) {
            pre = pre.next;
            slow = slow.next;
            quick = quick.next.next;
        }
        pre.next = null;
        ListNode cur = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = cur;
            cur = slow;
            slow = next;
        }
        while (head != null) {
            if (head.val == cur.val) {
                head = head.next;
                cur = cur.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
