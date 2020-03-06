package com.leetcode;

import java.util.HashSet;

/**
 * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [23,2,4,6,7], k = 6
 * 输出: True
 * 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
 * 示例 2:
 * <p>
 * 输入: [23,2,6,4,7], k = 6
 * 输出: True
 * 解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 */
public class leetcode523 {

    //前缀和
    public boolean checkSubarraySum1(int[] nums, int k) {
        int n = nums.length;
        int[] presum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j <= n; j++) {
                int res = presum[j] - presum[i];
                if (k == 0) {
                    if (res == 0) return true;
                } else {
                    if (res % k == 0) return true;
                }
            }
        }
        return false;

    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        //使用cache是因为需要间距至少为2
        int sums = 0, cache = 0;
        for (int i = 0; i < n; i++) {
            sums += nums[i];
            int res = k == 0 ? sums:sums%k;
            if (set.contains(res)) return true;
            set.add(cache);
            cache = res;
        }
        return false;
    }

}
