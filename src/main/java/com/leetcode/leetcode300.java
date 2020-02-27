package com.leetcode;

public class leetcode300 {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        //dp[i] 表示到第i个元素时的上升序列
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int a = nums[i - 1];
            dp[i] = 1;
            //在前i-1个元素找到比第i个元素小的最大的dp[x]
            int sc = 0;
            for (int j = 0; j < i - 1; j++) {
                if (nums[j] < a) {
                    sc = Math.max(sc, dp[j + 1]);
                }
            }
            dp[i] += sc;
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        //dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
        int[] dp = new int[n];

        int maxL=0;
        for (int num : nums) {
            int left = 0, right = maxL;
            while (left<right){
                int mid = (left+right)/2;
                if (dp[mid]<num){
                    left=mid+1;
                }else {
                    right = mid;
                }
            }
            dp[left] = num;
            if (left==maxL){
                maxL++;
            }
        }
        return maxL;

    }
}
