package com.leetcode;

import java.util.HashMap;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode76 {


    /**
     * 滑动窗口
     *int left = 0, right = 0;
     *
     * while (right < s.size()) {
     *     window.add(s[right]);
     *     right++;
     *
     *     while (valid) {
     *         window.remove(s[left]);
     *         left++;
     *     }
     * }
     *

     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer orDefault = tmap.getOrDefault(c, 0);
            tmap.put(c, orDefault + 1);
        }
        HashMap<Character, Integer> smap = new HashMap<>();
        int start = 0, end = -1;
        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int match = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (tmap.containsKey(c)) {
                Integer orDefault = smap.getOrDefault(c, 0);
                smap.put(c, orDefault + 1);
                if (smap.get(c).intValue() == tmap.get(c).intValue()) {
                    match++;
                }
            }
            right++;
            while (match == tmap.size()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                    end = right;
                }
                char sc = s.charAt(left);
                if (tmap.containsKey(sc)) {
                    Integer cnt = smap.getOrDefault(sc, 0);
                    smap.put(sc, cnt - 1);
                    if ( smap.get(sc).intValue() < tmap.get(sc).intValue()) {
                        match--;
                    }
                }
                left++;
            }
        }

        return end > -1 ? s.substring(start, end) : "";
    }

    public String minWindow1(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        //题目里没有说只是大写 在提交的时候踩了不少坑..

        int[] auxT = new int[128]; //auxT用来存目标字符串
        for (int i = 0; i < t.length(); i++) {
            auxT[t.charAt(i)]++;
        }
        int[] auxS = new int[128];//auxS用来存滑动窗口里的内容
        for (int i = 0; i < t.length(); i++) {
            auxS[s.charAt(i)]++;
        }

        //start end左右指针 min记录滑动窗口最小长度 startIndex记录最小长度的起始位置
        int start = 0, end = t.length(), min = Integer.MAX_VALUE, startIndex = 0;

        while (end <= s.length()) {
            while (check(auxS, auxT)) {//如果包含 就移动左指针缩小范围
                if (end - start < min) {
                    min = end - start;
                    startIndex = start;
                }
                auxS[s.charAt(start++)]--;
            }
            if (end <= s.length() - 1) { //这里判断一下end的越界问题
                auxS[s.charAt(end++)]++;
            } else {
                break;
            }
        }
        return min != Integer.MAX_VALUE ? s.substring(startIndex, startIndex + min) : "";
    }

    private boolean check(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] < nums2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        leetcode76 a = new leetcode76();

        System.out.println(a.minWindow("ADOBECODEBANC","ABC"));
    }
}
