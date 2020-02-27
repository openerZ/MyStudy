package com.offer;

/**
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class O64 {

    /**
     * 使用回溯法
     */
    private int count=0;
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold<0) return 0;

        //创建b标识数组 0表示未为走过，1表示走过，2表示不符合
        int[] flag = new int[rows * cols];

        judge(threshold,0,0,rows,cols,flag);
        return count;
    }


    private void judge(int threshold,int i,int j,int row,int cols,int[] flag){
        int index = i*cols+j;
        if (i<0 ||j<0 ||i>=row||j>=cols || flag[index]==1||flag[index]==2){
            return;
        }
        //计算i和j的数位之和
        int t = SW(i)+SW(j);
        if (t<=threshold){
            count++;
            flag[index]=1;
            judge(threshold,i+1,j,row,cols,flag);
            judge(threshold,i-1,j,row,cols,flag);
            judge(threshold,i,j+1,row,cols,flag);
            judge(threshold,i,j-1,row,cols,flag);

        }else {
            flag[index]=2;
        }
    }

    private int SW(int a){
        int res=0;
        while (a>0){
            int z = a%10;
            res += z;
            a=a/10;
        }
        return res;
    }
}
