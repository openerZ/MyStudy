package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 最大回文子串是被研究得比较多的一个经典问题。最近月神想到了一个变种，对于一个字符串，如果不要求子串连续，那么一个字符串的最大回文子串的最大长度是多少呢。
 * 输入描述:
 * 每个测试用例输入一行字符串（由数字0-9，字母a-z、A-Z构成），字条串长度大于0且不大于1000.
 * 输出描述:
 * 输出该字符串的最长回文子串的长度。（不要求输出最长回文串，并且子串不要求连续）
 * 示例1
 * 输入
 * 复制
 * adbca
 * 输出
 * 复制
 * 3
 * 说明
 * 因为在本题中，不要求回文子串连续，故最长回文子串为aba(或ada、aca)
 * 备注:
 * 因为不要求子串连续，所以字符串abc的子串有a、b、c、ab、ac、bc、abc7个
 */
public class MaxHW {

    /**
     * 动态规划
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = s.length();
        int[][] dp = new int[n][n];//dp[l][r]表示l-r中的最长回文串
        for (int r = 0; r < n; r++) {
            dp[r][r] = 1;
            for (int l = r - 1; l >= 0; l--) {
                if (s.charAt(l) == s.charAt(r)) {
                    dp[l][r] = dp[l + 1][r - 1] + 2;
                }else {
                    dp[l][r] = Math.max(dp[l+1][r],dp[l][r-1]);
                }
            }
        }
        System.out.println(dp[0][n-1]);


    }
}
