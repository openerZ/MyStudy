package com.leetcode;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * 输出: 4
 */
public class leetcode222 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;

        int n = matrix[0].length;
        //dp[i][j] 表示以当前位置为正方形的右下角的边长
        //dp[i][j]=1+min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]);
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]);
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }
        return max * max;
    }

    public int maximalSquare1(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n + 1];
        int max = 0;
        int pre;

        for (int i = 0; i < m; i++) {
            pre=0;
            for (int j = 0; j < n; j++) {
                int temp = dp[j + 1];
                if (matrix[i][j] == '1') {
                    dp[j + 1] = 1 + Math.min(Math.min(dp[j + 1], dp[j]), pre);
                    max = Math.max(max, dp[j + 1]);
                }else {
                    dp[j+1] = 0;
                }
                pre = temp;
            }
        }
        return max * max;
    }
}
