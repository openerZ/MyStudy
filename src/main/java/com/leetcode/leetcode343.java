package com.leetcode;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class leetcode343 {


    public int integerBreak1(int n) {
        if (n<4) return n-1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <=n ; i++) {
            for (int j = 1; j <=i/2 ; j++) {
                dp[i] = Math.max(dp[i],dp[j]*dp[i-j]);
            }
        }
        return dp[n];

    }
    public int integerBreak(int n) {
        if (n<4) return n-1;
        int a = n/3;
        n%=3;
        if (n==1){
            a-=1;
            n+=3;
        }
        return (int) (Math.pow(3,a)*(n==0?1:n));

    }
}
