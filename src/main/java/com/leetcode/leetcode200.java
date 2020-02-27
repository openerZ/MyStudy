package com.leetcode;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 */
public class leetcode200 {

    boolean[][] isVisited;
    char[][] gd;

    public int numIslands(char[][] grid) {

        int count = 0;
        if (grid.length == 0) return count;
        int row = grid.length;
        int col = grid[0].length;
        gd = grid;
        isVisited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    isVisited[i][j] = true;
                    dfs(i + 1, j);
                    dfs(i - 1, j);
                    dfs(i, j + 1);
                    dfs(i, j - 1);
                    count++;
                }

            }
        }

        return count;
    }

    private void dfs(int i, int j) {
        int n = gd.length;
        int m = gd[0].length;
        if ((i >= n || i < 0) || (j < 0 || j >= m) || gd[i][j] == '0' || isVisited[i][j]) return;
        isVisited[i][j] = true;
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);

    }
}
