package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OnlyOne {
    public char firstUniqChar(String s) {
        int[] ca = new int[256];
        Queue<Character> qq = new LinkedList<>();
        for (char c : s.toCharArray()) {
            ca[c]++;
            qq.add(c);
            while (!qq.isEmpty()&&ca[qq.peek()]>1){
                qq.poll();
            }
        }

        return  qq.peek()==null?' ': qq.peek();
    }
    public char firstUniqChar1(String s) {
        int[] ca = new int[256];
        for (char c : s.toCharArray()) {
            ca[c-'a']++;
        }
        for (char c : s.toCharArray()) {
            if (ca[c-'a']==1) return c;
        }
        return ' ';
    }

}
