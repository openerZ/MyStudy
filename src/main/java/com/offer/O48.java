package com.offer;

import java.util.HashMap;

/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）
 */
public class O48 {

    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }


    public static int FirstNotRepeatingChar1(String str) {
        int[] words = new int['z'+1];
        for (int i = 0; i < str.length(); i++) {
            words[str.charAt(i)] += 1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (words[str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }
}
