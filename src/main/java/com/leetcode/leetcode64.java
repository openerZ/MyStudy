package com.leetcode;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class leetcode64 {

    public int minPathSum(int[][] grid) {
        if (grid==null) return 0;
        int rl = grid.length;
        int cl = grid[0].length;
        int[][] dp = new int[rl][cl];
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                dp[i][j]=grid[i][j];
                if (i>0){
                    if (j>0){
                        dp[i][j]+=Math.min(dp[i-1][j],dp[i][j-1]);
                    }else {
                        dp[i][j]+=dp[i-1][j];
                    }
                }else {
                    if (j>0){
                        dp[i][j]+=dp[i][j-1];
                    }
                }
            }
        }
        return dp[rl -1][cl -1];
    }
}
