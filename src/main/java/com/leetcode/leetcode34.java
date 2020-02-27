package com.leetcode;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class leetcode34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] a = {-1, -1};
        if (nums == null || nums.length == 0) return a;
        a[0] = leftIndex(nums,0,nums.length-1,target);
        a[1] = rightIndex(nums,0,nums.length-1,target);
        return a;
    }

    private static int leftIndex(int[] nums, int left, int right, int target) {

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private static int rightIndex(int[] nums, int left, int right, int target) {

        while (left < right) {
            int mid = left + (right - left) / 2+1;
            if (nums[mid] <= target) {
                left=mid;
            } else {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] a={5,7,7,8,8,10};
        searchRange(a,8);
    }
}
