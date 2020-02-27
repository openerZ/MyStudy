package com.leetcode;

public class leetcode883 {

    public int projectionArea(int[][] grid) {
        if (grid.length==0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            int rowMax=0,colsMax=0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]!=0){
                  res++;
                }
                //计算第i行的最大值
                rowMax=Math.max(rowMax,grid[i][j]);
                //计算第i列的最大值
                colsMax = Math.max(colsMax,grid[j][i]);
            }
            res = res+rowMax+colsMax;
        }
        return res;
    }
}
