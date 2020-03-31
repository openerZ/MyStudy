package com.leetcode;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class leetcode84 {

    public int largestRectangleArea(int[] heights) {
        int i = 0;
        int n = heights.length;
        int res = 0;
        if (n == 0) return 0;
        while (i < n) {
            int l = i;
            while (l >= 0 && heights[l] >= heights[i]) {
                l--;
            }
            int r = i;
            while (r < n && heights[r] >= heights[i]) {
                r++;
            }
            int len = r - l - 1;
            res = Math.max(res, len * heights[i]);
            i++;
        }
        return res;
    }

    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;
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
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;

    }

    public int largestRectangleArea2(int[] heights) {

        //单调非递减栈
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int n = heights.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                int num = stack.pop();
                res = Math.max(res, heights[num] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        for (int i = 1; i <stack.size() ; i++) {
            Integer k = stack.get(i);
            res = Math.max(res,heights[k]*(stack.peek()-stack.get(i-1)-1));
        }
        return res;
    }

}
