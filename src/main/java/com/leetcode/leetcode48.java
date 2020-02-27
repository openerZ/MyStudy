package com.leetcode;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class leetcode48 {

    public void rotate(int[][] matrix) {

        int row = 0, cols = 0, rowlength = matrix.length - 1, colsLength = matrix[0].length - 1;
        int t1 = 0;
        int t2 = 0;
        while (row < rowlength) {
            int r = row, c = cols;
            int rl = rowlength, cl = colsLength;

            while (c < colsLength) {
                //右边
                t1 = matrix[r][colsLength];
                matrix[r][colsLength] = matrix[row][c];

                //下边
                t2 = matrix[rowlength][cl];
                matrix[rowlength][cl] = t1;

                //左边
                t1 = matrix[rl][cols];
                matrix[rl][cols] = t2;

                //上边
                matrix[row][c] = t1;
                r++;
                c++;
                cl--;
                rl--;
            }
            row++;
            cols++;
            rowlength--;
            colsLength--;
        }
    }

    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        //先对角交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        //在左右对称调换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length/2; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j]=temp;
            }

        }

    }
}
