package com.leetcode;

import java.util.*;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2:
 * <p>
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 */
public class leetcode188 {

    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) return 0;

        if (k > prices.length / 2)
            return maxProfit1(prices);
        //dp[i][k][0/1]表示第i天在交易了k次的情况下持有/未持有股票的情况下的最大利益
        int[][][] dp = new int[prices.length][k + 1][2];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }

        }
        return dp[prices.length - 1][k][0];
    }

    public int maxProfit1(int[] prices) {
        if (prices.length <= 1) return 0;
        int max = 0;
        int pre = prices[0], buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > pre) {
                pre = prices[i];
            } else {
                max += (pre - buy);
                buy = pre = prices[i];
            }
        }
        max += (pre - buy);
        return max;

    }




}
