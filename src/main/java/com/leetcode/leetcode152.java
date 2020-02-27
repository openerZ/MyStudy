package com.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Map;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode152 {


    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;

    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 0;
        for (int i = 0; i < nums.length; i++) {
            imax=Math.max(imax+nums[i],nums[i]);
            max=Math.max(max,imax);
        }
        return max;
    }

    public int maxProduct1(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        //dp[i][j] 表示从i-j的乘积
        int temp = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    temp = nums[j];
                } else {
                    temp = temp * nums[j];
                }
                max = Math.max(temp, max);
            }
        }

        return max;
    }
}
