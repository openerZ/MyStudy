package com.leetcode;


import java.util.Arrays;

/**
 * 739. 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class leetcode739 {

    public int[] dailyTemperatures(int[] T) {

        int[] dp = new int[101];
        Arrays.fill(dp,-1);
        int n = T.length;
        int[] ans = new int[n];
        for (int i = n-1; i >=0 ; i--) {
            int a = T[i];
            dp[a] = i;
            int temp=Integer.MAX_VALUE;
            for (int j = a+1; j <=100 ; j++) {
                if (dp[j]!=-1){
                    temp = Math.min(dp[j]-i,temp);
                }
            }
            ans[i] = temp!=Integer.MAX_VALUE?temp:0;
        }

        return ans;
    }

}
