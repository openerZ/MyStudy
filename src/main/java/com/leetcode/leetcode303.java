package com.leetcode;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 示例：
 * <p>
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * <p>
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode303 {
    int[] preSum;
    public void NumArray(int[] nums) {
        int n = nums.length;
        preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] += preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return preSum[j + 1] - preSum[i];
    }
}
