package com.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * LRUCache cache = new LRUCache( 2 /* 缓存容量
 */

public class LRUCache {

    class Node {
        Node next;
        Node pre;
        int key;
        int value;

        public Node(int key, int value) {
            this.next = this;
            this.pre = this;
            this.key = key;
            this.value = value;
        }
    }
    private HashMap<Integer,Node> map;
    private int capacity;
    private Node head = new Node(-1,-1);
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            //调整双向链表
            refresh(node);
            return node.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node;
        if (map.containsKey(key)){
            node = map.get(key);
            node.value = value;
        }else {
            node = new Node(key, value);
            map.put(key,node);
        }
        //调整双向链表
        refresh(node);
        if (map.size()>capacity){
            //删除节点
            del();
        }
    }

    private void refresh(Node node){
        //断开连接
        node.pre.next = node.next;
        node.next.pre = node.pre;

        //将node节点插入到head后边
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    private Node del(){
        //待删除节点
        Node node = head.pre;

        map.remove(node.key);

        head.pre =node.pre;
        node.pre.next = head;

        node.pre=null;
        node.next=null;
        return node;
    }
}
