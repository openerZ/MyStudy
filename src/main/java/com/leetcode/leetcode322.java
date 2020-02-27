package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class leetcode322 {


    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if (dp[i - coins[j]]!=Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i],1+dp[i - coins[j]]);
                    }
                }
            }
        }
        return dp[amount]!=Integer.MAX_VALUE?dp[amount]:-1;
    }

}
