package com.leetcode;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 *
 * 输入的字符串长度不会超过1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode647 {

    /**
     * dp
     * @param s
     * @return
     */
    public int countSubstrings1(String s) {

        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];

        for(int j = 0;j<n;j++){

            for (int i = 0; i <=j; i++) {
                if (s.charAt(i)==s.charAt(j)){
                    if (j-i<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                    if (dp[i][j]){
                        res++;
                    }
                }else {
                    dp[i][j] =false;
                }
            }
        }

        return res;
    }

    /**
     * 中心扩散法
     */
    private int num=0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            countHW(s,i,i);
            countHW(s,i,i+1);
        }
        return num;
    }


    private void countHW(String s,int i,int j){
        int n = s.length();
        while (i>=0&& j< n && s.charAt(i)==s.charAt(j)){
            num++;
            i--;
            j++;
        }
    }

}
