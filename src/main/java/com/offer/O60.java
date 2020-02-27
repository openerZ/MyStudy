package com.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class O60 {

    ArrayList<Character> list=new ArrayList<>(); //记录出现的字符顺序
    HashMap<Character,Integer> map= new HashMap<>(); //记录字符出现的次数
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch,map.get(ch)+1);
        }else {
            map.put(ch,1);
        }
        list.add(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Character c : list) {
            if (map.get(c)==1){
                return c;
            }

        }
        return '#';
    }

    private int[] cnts = new int[256]; //用ASCII下标记录字符出现的次数
    private Queue<Character> queue = new LinkedList<>();

    public void Insert1(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1)
            queue.poll();
    }

    public char FirstAppearingOnce1() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
