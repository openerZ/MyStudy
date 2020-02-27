package com.leetcode;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class leetcode49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        //key为排序的单词
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            //单词排序
            Arrays.sort(chars);
            String c = String.valueOf(chars);
            if (map.containsKey(c)){
                map.get(c).add(strs[i]);
            }else {
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(c,list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        HashMap<Integer, List<String>> hash = new HashMap<>();
        //每个字母对应一个质数
        int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
        for (int i = 0; i < strs.length; i++) {
            int key = 1;
            //累乘得到 key
            for (int j = 0; j < strs[i].length(); j++) {
                key *= prime[strs[i].charAt(j) - 'a'];
            }
            if (hash.containsKey(key)) {
                hash.get(key).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                hash.put(key, temp);
            }

        }
        return new ArrayList<List<String>>(hash.values());
    }
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] used = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            List<String> temp = null;
            if (!used[i]) {
                temp = new ArrayList<String>();
                temp.add(strs[i]);
                //两两比较判断字符串是否符合
                for (int j = i + 1; j < strs.length; j++) {
                    if (equals(strs[i], strs[j])) {
                        used[j] = true;
                        temp.add(strs[j]);
                    }
                }
            }
            if (temp != null) {
                ans.add(temp);

            }
        }
        return ans;

    }



    private boolean equals(String string1, String string2) {
        Map<Character, Integer> hash = new HashMap<>();
        //记录第一个字符串每个字符出现的次数，进行累加
        for (int i = 0; i < string1.length(); i++) {
            if (hash.containsKey(string1.charAt(i))) {
                hash.put(string1.charAt(i), hash.get(string1.charAt(i)) + 1);
            } else {
                hash.put(string1.charAt(i), 1);
            }
        }
        //记录第一个字符串每个字符出现的次数，将之前的每次减 1
        for (int i = 0; i < string2.length(); i++) {
            if (hash.containsKey(string2.charAt(i))) {
                hash.put(string2.charAt(i), hash.get(string2.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        //判断每个字符的次数是不是 0 ，不是的话直接返回 false
        Set<Character> set = hash.keySet();
        for (char c : set) {
            if (hash.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}
