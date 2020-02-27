package com.leetcode;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class leetcode91 {
    int k=0;
    public int numDecodings(String s) {
        HS(s,0);
        return k;
    }

    //回溯法：会超时
    private void HS(String s,int index){
        if (s.length()==index){
            k++;
            return;
        }
        for (int i = index+1; i <= index+2&&i<=s.length(); i++) {
            Integer dq = Integer.valueOf(s.substring(index, i));
            if (dq>0 &&dq<27){
                HS(s,i);
            }else {
                break;
            }
        }
    }


    /**
     * 使用动态规划
     * @param s
     * @return
     */
    public int numDecodings1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        //从后向前遍历
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        leetcode91 a = new leetcode91();
        System.out.println(a.numDecodings("21226"));
    }
}
