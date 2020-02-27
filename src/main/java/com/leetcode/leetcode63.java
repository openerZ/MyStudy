package com.leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class leetcode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rl = obstacleGrid.length;
        int cl = obstacleGrid[0].length;
        int[][] dp = new int[rl][cl];

        if (obstacleGrid[0][0] == 1) return 0;
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (i == 0) {
                    if (obstacleGrid[i][j] != 1) {
                        dp[i][j] = 1;
                    } else {
                        break;
                    }
                } else if (j == 0 && i > 0) {
                    if (obstacleGrid[i][j] != 1) {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    if (obstacleGrid[i][j] != 1) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }
        return dp[rl - 1][cl - 1];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int rl = obstacleGrid.length;
        int cl = obstacleGrid[0].length;
        int[] steps = new int[cl];
        for (int i = 0; i < cl; i++) {
            if (obstacleGrid[0][i] != 1) {
                steps[i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (obstacleGrid[i][j] != 1) {
                    if (j == 0) {
                        steps[j] = steps[j];
                    } else {
                        steps[j] = steps[j - 1] + steps[j];
                    }
                } else {
                    steps[j] = 0;
                }
            }
        }
        return steps[cl - 1];
    }
}
