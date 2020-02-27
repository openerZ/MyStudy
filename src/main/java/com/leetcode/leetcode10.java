package com.leetcode;


/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class leetcode10 {

    int ls, lp;

    public boolean isMatch(String s, String p) {
        ls = s.length();
        lp = p.length();
        return match(s, p, 0, 0);
    }

    private boolean match(String s, String p, int i, int j) {
        if (j == lp) return i == ls;
        if (j < lp - 1 && p.charAt(j + 1) == '*') {
            if (i < ls && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)))
                return match(s, p, i + 1, j) || match(s, p, i, j + 2);
            return match(s, p, i, j + 2);
        }
        if (i < ls && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)))
            return match(s, p, i + 1, j + 1);
        return false;
    }



    public boolean isMatch1(String s, String p) {
        char[] chars=s.toCharArray();
        char[] charp=p.toCharArray();
        if(!isValid(charp)){
            return false;
        }
        return process(chars,charp,0,0);

    }

    public static boolean process(char[] s,char[] p,int si,int pi){
        //来到终止位置，当exp耗尽了的情况
        if(pi==p.length){
            return si==s.length;
        }

        //pi还有字符，考察pi+1的情况
        if(pi+1==p.length||p[pi+1]!='*'){
            return (si!=s.length&&(s[si]==p[pi]||p[pi]=='.')&&process(s,p,si+1,pi+1));
        }

        //pi+1的位置不仅有字符而且字符是“*”
        //理解：若没法匹配(循环中不能return true)，指针保持pi暂时不动，si往后移动继续判断
        while(si!=s.length&&(s[si]==p[pi]||p[pi]=='.')){
            if(process(s,p,si,pi+2)){
                return true;
            }
            si++;
        }
        return process(s,p,si,pi+2);


    }

    public static boolean isValid(char[] p){
        for(int i=0;i<p.length;i++){
            if(p[i]=='*'&&(i==0||p[i-1]=='*')){
                return false;
            }
        }
        return true;
    }


}
