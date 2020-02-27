package com.leetcode;

import java.util.HashSet;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
public class leetcode73 {

    /**
     * 使用O(m+n)的额外空间
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {

        int rl = matrix.length;
        int cl = matrix[0].length;
        int[] row = new int[rl];
        int[] cols = new int[cl];
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (matrix[i][j]==0){
                    row[i]++;
                    cols[j]++;
                }
            }
        }
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (matrix[i][j]!=0 &&(row[i]>0||cols[j]>0)){
                    matrix[i][j]=0;
                }
            }
        }
    }

    /**
     *使用常数空间
     * @param matrix
     */
    public void setZeroes1(int[][] matrix) {
        //使用两个boolean标识第一行和第一列是否出现0
        boolean rf = false;
        boolean cf = false;
        int rl = matrix.length;
        int cl = matrix[0].length;
        //第一行是否有0
        for (int i = 0; i <cl ; i++) {
            if (matrix[0][i]==0){
                rf=true;
                break;
            }
        }
        //第一列是否有0
        for (int i = 0; i <rl ; i++) {
            if (matrix[i][0]==0){
                cf=true;
                break;
            }
        }
        for (int i = 1; i < rl; i++) {
            for (int j = 1; j < cl; j++) {
                //除第一行和第一列外出现0就先将当前所在行的第一列和当前列的第一行置位0
                if (matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for (int i = 1; i < rl; i++) {
            for (int j = 1; j < cl; j++) {
                //根据当前所在行的第一列和当前列的第一行是否为0
                if (matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        //标识第一行是否需要置为0
        if (rf){
            for (int i = 0; i < cl; i++) {
                matrix[0][i]=0;
            }
        }
        //标识第一列是否需要置为0
        if (cf){
            for (int i = 0; i < rl; i++) {
                matrix[i][0]=0;
            }
        }
    }
}
