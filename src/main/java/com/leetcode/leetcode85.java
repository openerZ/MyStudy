package com.leetcode;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode85 {
    int res=0;
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n==0) return 0;
        int m = matrix[0].length;
        int[] heights = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j]=='1'){
                    heights[j]+=1;
                }else {
                    heights[j]=0;
                }
            }
            largestRectangleArea1(heights);
        }
        return res;
    }

    public void largestRectangleArea1(int[] heights) {
        int n = heights.length;
        if (n==0) return;
        //left[i]表示的是在i的左边第一个比heights[i]小的数的下标
        int[] left = new int[n];
        //right[i]表示的是在i的右边第一个比heights[i]小的数的下标
        int[] right = new int[n];
        left[0] = -1;
        right[n - 1] = n;
        for (int i = 1; i < n; i++) {
            int temp = i - 1;
            //进行跳跃查询
            while (temp >= 0 && heights[temp] >= heights[i]) temp = left[temp];
            left[i] = temp;
        }
        for (int i = n - 2; i >= 0; i--) {
            int temp = i + 1;
            while (temp < n && heights[temp] >= heights[i]) temp = right[temp];
            right[i] = temp;
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
    }
}
