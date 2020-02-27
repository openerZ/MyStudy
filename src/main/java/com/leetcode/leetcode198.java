package com.leetcode;

import org.omg.CORBA.MARSHAL;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
 * 系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class leetcode198 {


    public int rob1(int[] nums) {
        int n = nums.length;
        if (n==0) return 0;
        //dp[i] 表示到第i个房子的时候的最大收益 dp[i]=Math.max(dp[i-2]+nums[i-1],dp[i-1])
        int[] dp = new int[n +1];
        dp[1] = nums[0];
        for (int i = 2; i <=n; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i-1],dp[i-1]);
        }
        return dp[n];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        //dp[i][0] 表示到第i个屋子不偷时此时的最大的收益 dp[i][0] =Math.max(dp[i-1][1],dp[i-1][0])
        //dp[i][1] 表示到第i个屋子偷时此时的最大的收益 dp[i][1] = dp[i-1][0]+num[i-1]
        int[][] dp = new int[n +1][2];
        for (int i = 1; i <= n; i++) {
            dp[i][0] =Math.max(dp[i-1][1],dp[i-1][0]);
            dp[i][1] =dp[i-1][0]+nums[i-1];
        }

        return Math.max(dp[n][0],dp[n][1]);
    }
}
