package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class leetcode438 {


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) return list;
        HashMap<Character, Integer> pmap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            pmap.put(c, pmap.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> smap = new HashMap<>();
        int match = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (pmap.containsKey(c)) {
                smap.put(c, smap.getOrDefault(c, 0) + 1);
                if (smap.get(c).intValue() == pmap.get(c).intValue()) {
                    match++;
                }
            }
            right++;
            while (match == pmap.size()) {
                if (right - left == p.length()) {
                    list.add(left);
                }
                char cL = s.charAt(left);
                if (pmap.containsKey(cL)) {
                    smap.put(cL, smap.get(cL) - 1);
                    if (smap.get(cL).intValue() < pmap.get(cL).intValue()) {
                        match--;
                    }
                }
                left++;
            }
        }
        return list;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) return list;
        int[] parr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            parr[p.charAt(i) - 'a']++;
        }
        int[] sarr = new int[26];
        //匹配符合的字符个数
        int match = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            int c = s.charAt(right) - 'a';
            if (parr[c] > 0) {
                sarr[c]++;
                if (sarr[c] <= parr[c]) {
                    match++;
                }
            }
            right++;
            while (match == p.length()) {
                if (right - left == p.length()) {
                    list.add(left);
                }
                char cL = s.charAt(left);
                if (parr[cL-'a']>0){
                    sarr[cL-'a']--;
                    if (sarr[cL-'a'] < parr[cL-'a']) {
                        match--;
                    }
                }
                left++;
            }
        }
        return list;

    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        //保存窗口的当前字符
        int[] curAToZ = new int[26];
        //目标数组
        int[] aToZ = new int[26];
        for (char c : pChar) {
            aToZ[c - 'a']++;
        }
        for (int i = 0; i < sChar.length; i++) {
            if (i >= pChar.length) {
                //将窗口的最左边减去
                curAToZ[sChar[i - pChar.length] - 'a']--;
            }
            curAToZ[sChar[i] - 'a']++;
            if (Arrays.equals(curAToZ, aToZ)) {
                result.add(i - pChar.length + 1);
            }
        }
        return result;
    }
}
