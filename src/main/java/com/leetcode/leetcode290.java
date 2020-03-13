package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode290 {
    public boolean wordPattern(String pattern, String str) {
        char[] pa = pattern.toCharArray();
        String[] sp = str.split(" ");
        if (sp.length!=pa.length) return false;

        Map<Character,String> map = new HashMap<>();
        for (int i = 0; i < pa.length; i++) {
            char c = pa[i];
            if (map.containsKey(c)){
                if (!map.get(c).equals(sp[i])){
                    return false;
                }
            }else {
                if (map.containsValue(sp[i])) return false;
                map.put(c,sp[i]);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        leetcode290 ll = new leetcode290();
        boolean b = ll.wordPattern("abba", "dog cat cat dog");
        System.out.println(b);

    }
}
