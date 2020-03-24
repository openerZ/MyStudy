package com.mynote;

//0-1背包问题
public class Backage0_1 {

    /**
     *
     *
     * @param k 背包的重量
     * @param weight 物品的重量
     * @param values 物品的价值
     * @return
     */
    public int knapsack(int k,int[] weight,int[] values){
        int n = weight.length;
        //dp[i][j] 表示有i个物品 背包j重量下最大的价值
        int[][] dp = new int[n+1][k+1];

        for (int i = 1; i <=n ; i++) {
            int w = weight[i-1];
            int v = values[i-1];
            for (int j = 1; j <=k; j++) {
                if (j>=w){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w]+v);
                }else {
                    dp[i][j] =dp[i-1][j];
                }
            }
        }

        return dp[n][k];
    }

    public int knapsack1(int k,int[] weight,int[] values){
        int n = weight.length;
        //dp[i]表示背包i时的最大价值
        int[] dp = new int[k+1];

        for (int i = 1; i <=n ; i++) {
            int w = weight[i-1];
            int v = values[i-1];
            for (int j = k; j >0; j--) {
                if (j>=w){
                    dp[j]=Math.max(dp[j],dp[j-w]+v);
                }
            }
        }
        return dp[k];
    }
}
