package com.leetcode;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class leetcode59 {

    public int[][] generateMatrix(int n) {
        if (n <= 0) return null;
        int[][] arr = new int[n][n];

        int row = 0, cols = 0, rowLength = n - 1, colsLength = n - 1;

        int num = 1;
        while (row <= rowLength && cols <= colsLength) {
            //上边
            for (int i = cols; i <= colsLength; i++) {
                arr[row][i] = num++;
            }

            row++;
            //右边
            for (int i = row; i <= rowLength; i++) {
                arr[i][colsLength] = num++;

            }
            colsLength--;
            //下边
            for (int i = colsLength; i >= cols; i--) {
                arr[rowLength][i] = num++;
            }
            rowLength--;
            //左边
            for (int i = rowLength; i >= row; i--) {
                arr[i][cols] = num++;
            }
            cols++;
        }

        return arr;
    }
}
