package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class leetcode03 {


    /**
     * 思路
     * 标签：滑动窗口
     * 暴力解法时间复杂度较高，会达到 O(n^2)O(n
     * 2
     *  )，故而采取滑动窗口的方法降低时间复杂度
     * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
     * 我们定义不重复子串的开始位置为 start，结束位置为 end
     * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
     * 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
     * 时间复杂度：O(n)O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int max=0;
        int start=0;
        for (int end=0;end<length;end++){
            char c = s.charAt(end);
            if (map.containsKey(c)){
                start = Math.max(start,map.get(c));
            }
            map.put(c,end+1);
            max = Math.max(max,end-start+1);
        }
        return max;
    }

    /**
     * 暴力破解：遍历所有无重复字节找出最大
     * 时间复杂度O(n^2)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {

        char[] chars = s.toCharArray();
        int length = chars.length;
        int max=0;
        for (int i = 0; i < length; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < length; j++) {
                char a=chars[j];
                if (set.contains(a)) {
                    break;
                }else {
                    set.add(a);
                    max=Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }





    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abdc"));

    }
}
