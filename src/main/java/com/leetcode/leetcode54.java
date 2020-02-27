package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class leetcode54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;
        int row = 0, cols = 0, rowlength = matrix.length - 1, colsLength = matrix[0].length - 1;

        while (row <= rowlength && cols <= colsLength) {
            int r = row, c = cols;
            //上边
            for (int i = c; i <= colsLength; i++) {
                list.add(matrix[r][i]);
            }

            //右边
            for (int i = r + 1; i <= rowlength; i++) {
                list.add(matrix[i][colsLength]);
            }

            //下边
            if (r < rowlength) {
                for (int i = colsLength - 1; i >= c; i--) {
                    list.add(matrix[rowlength][i]);
                }
            }

            //左边
            if (c < colsLength) {
                for (int i = rowlength - 1; i > r; i--) {
                    list.add(matrix[i][c]);
                }
            }

            row++;
            cols++;
            rowlength--;
            colsLength--;

        }

        return list;
    }

}
