package com.leetcode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class leetcode122 {

    /**
     * 记录一个先前价格pre
     * 1.如果当前价格大于pre，那么更新pre=当前价格
     * 2.如果小于等于当前价格，那么pre-buy是目前的最大利益，让buy= pre = 当前价格
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length<=1) return 0;
        int max = 0;
        int pre = prices[0], buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > pre) {
                pre = prices[i];
            }else {
                max += (pre - buy);
                buy = pre = prices[i];
            }
        }
        max+=(pre-buy);
        return max;

    }

    public static void main(String[] args) {

        int[] a ={7,1,5,3,6,4};
        leetcode122 ll = new leetcode122();
        System.out.println(ll.maxProfit(a));
    }
}
