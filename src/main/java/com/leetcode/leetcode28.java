package com.leetcode;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class leetcode28 {

    public int strStr(String haystack, String needle) {
        if  (haystack.equals("") && needle.equals("")) return 0;
        if (haystack.equals("")) return -1;
        if (needle.equals("")) return 0;

        int ppL = needle.length() - 1;
        int index = ppL;
        boolean flag = true;
        while (index < haystack.length()) {
            if (needle.charAt(ppL) == haystack.charAt(index)) {
                if (flag) {
                    flag = !flag; //false
                }
                if (ppL == 0) {
                    return index ;
                }
                ppL--;
                index--;
            } else {
                if (!flag) {
                    flag = !flag; //true
                    index += needle.length() - 1 - ppL;
                    ppL = needle.length() - 1;
                }
                index++;
            }
        }
        return -1;

    }
}
