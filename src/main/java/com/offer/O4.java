package com.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class O4 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 使用头插法
     *头插法顾名思义是将节点插入到头部：在遍历原始链表时，
     * 将当前节点插入新链表的头部，使其成为第一个节点。
     * 链表的操作需要维护后继关系，
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode next = listNode.next;  //现将当前节点的下一个节点保存
            listNode.next = head.next;
            head.next = listNode;
            listNode = next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        head = head.next;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return list;

    }

    /**
     * 使用栈：
     * 栈具有后进先出的特点，在遍历链表时将值按顺序放入栈中，最后出栈的顺序即为逆序
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }

        return list;

    }


    /**
     * 使用递归调用
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode!=null){
            list.addAll(printListFromTailToHead3(listNode.next));
            list.add(listNode.val);
        }
        return list;

    }
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode root = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(6);

        ArrayList<Integer> list = printListFromTailToHead(root);
        System.out.println(list);


    }
}
