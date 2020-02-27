package com.leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class leetcode16 {

    /**
     * 排序固定单数，双指针逼近
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length <3) return 0;

        Arrays.sort(nums);
        int length = nums.length;

        //因为是比较值，所以初始值就是用原数组的值
        int res = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < length; i++) {

            int l = i + 1;
            int r = length - 1;
            while (l < r) {
                int a = nums[l] + nums[r] + nums[i];
                if (Math.abs(target - res) >Math.abs(target - a)) {
                    res = a;
                }
                if (a > target) {
                    r--;
                } else if (a < target) {
                    l++;
                } else {
                    return a;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0, 1, 2}, 0));

    }
}
