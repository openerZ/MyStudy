package com.leetcode;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 * <p>
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 * <p>
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 * <p>
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 */
public class leetcode44 {

    public boolean isMatch(String s, String p) {


        int i=0,j=0,sStart=-1,pStart=-1,sLen = s.length(),pLen=p.length();
        while (i<sLen){
            if (j < pLen && s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                i++;
                j++;
            }else if (j<pLen && p.charAt(j)=='*'){
                sStart=i;
                pStart=j;
                j++;
            }else if (sStart>=0){ //如果没有匹配成功并且之前匹配过*
                //重置i，j
                i=++sStart;
                j=pStart+1;  //让j为非"*"的字符
            }else {
                return false;
            }
        }
        //当实例字符匹配完成，那么匹配字符如果没匹配完只能出现*
        while (j<pLen&&p.charAt(j)=='*'){
            j++;
        }

        return j==pLen;

    }
}
