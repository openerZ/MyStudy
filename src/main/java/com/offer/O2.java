package com.offer;


/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 */
public class O2 {

    /**
     *在右上角数比他小的数在其左边，比他大的数在其右边
     * 所以可以从右上角开始比较，一次至少缩小一行或一列
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        int row = array.length;
        int cols = array[0].length;
        int r=0;
        int c=cols-1;
        while (r<=row-1 && c>=0){
            if (array[r][c]==target){
                return true;
            }else if (array[r][c]<target){
                r++;
            }else {
                c--;
            }
        }


        return false;
    }

    /**
     * 从左下角也可以
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find1(int target, int [][] array) {
        int row = array.length;
        int cols = array[0].length;
        int r=row-1;
        int c=0;
        while (r>=0 && c<cols){
            if (array[r][c]==target){
                return true;
            }else if (array[r][c]<target){
                c++;
            }else {
                r--;
            }
        }
        return false;
    }
}
