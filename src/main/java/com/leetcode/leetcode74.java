package com.leetcode;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class leetcode74 {


    /**
     * 变种二分法：
     *  mid/colsLength=i坐标 mid%colsLength=j坐标
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0) return false;
        int rl = matrix.length ;
        int cl = matrix[0].length;
        int start=0,end=rl*cl - 1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if (matrix[mid/cl][mid%cl]<target){
                start=mid+1;
            }else if (matrix[mid/cl][mid%cl]>target){
                end=mid-1;
            }else {
                return true;
            }
        }
        return false;

    }
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0) return false;
        int rl = matrix.length - 1;
        int cl = matrix[0].length - 1;
        //从矩阵的右上角开始
        int i = 0, j = cl;
        while (i <= rl && j >= 0) {
            if (matrix[i][j] < target) {
                i++;
            }else if (matrix[i][j]>target){
                j--;
            }else {
                return true;
            }
        }
        return false;
    }
}
