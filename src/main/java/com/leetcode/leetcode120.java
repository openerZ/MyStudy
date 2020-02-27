package com.leetcode;

import org.omg.CORBA.MARSHAL;
import sun.nio.cs.ext.MacArabic;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 */
public class leetcode120 {
    /**
     * 从上向下推
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        int pre = dp[0];
        int temp;
        for (int i = 1; i < n; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                temp = dp[j];
                dp[j] = list.get(j);
                if (j == 0) {
                    dp[j] += temp;
                } else if (j == list.size() - 1) {
                    dp[j] += pre;
                } else {
                    dp[j] += Math.min(pre, temp);
                }
                pre = temp;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : dp) {
            res = Math.min(res, i);
        }
        return res;
    }

    /**
     * 从底向上推
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n+1];

        for (int i = n-1; i >=0 ; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[j]=Math.min(dp[j],dp[j+1])+list.get(j);
            }
        }
        return dp[0];
    }
}
