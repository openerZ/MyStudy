package com.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class leetcode33 {


    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] > target) { //如果存在必在较小段
                if (nums[mid] < nums[left] && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { //那么只能在较大段
                if (nums[mid] > nums[left] && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static int search1(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[l]==target){
                return l;
            }
            if (nums[h]==target){
                return h;
            }
            //在小段
            if (nums[l] > target) {
                if (nums[m] > target && nums[m] < nums[l]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            } else { //在大段
                //num[m]有两种情况小于tagert,num[m]在大段和小段
                if (nums[m] < target && nums[m] > nums[l]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }

        return nums[l] == target ? l : -1;
    }


    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 8, 9, 15, 0, 1, 2};
        int search = search(a, 15);
        System.out.println(search);

    }
}
