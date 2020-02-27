package com.leetcode;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class leetcode67 {

    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int jw=0;
        int al=a.length()-1,bl=b.length()-1;
        while (al>=0 ||  bl>=0){
            if (al>=0){
                jw+= a.charAt(al--) - '0';
            }
            if (bl>=0){
                jw+= b.charAt(bl--) - '0';
            }
            str.append(jw%2);
            jw/=2;
        }
        if (jw>0){
            str.append(jw);
        }
        return  str.reverse().toString();
    }
}
