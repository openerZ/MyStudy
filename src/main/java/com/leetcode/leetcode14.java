package com.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class leetcode14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String s1 = strs[0];
        int index = 0;
        while (index < strs.length) {
            String sb = strs[index];
            int i = 0;
            while (i < s1.length() && i < sb.length()) {
                if (s1.charAt(i) != sb.charAt(i)) {
                    break;
                }
                i++;
            }
            s1 = s1.substring(0,i);
            if (s1.equals("")){
                return "";
            }
            index++;
        }
        return s1;
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String str = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(str) != 0){
                str=str.substring(0, str.length() - 1);
            }
        }
        return str;
    }
}
