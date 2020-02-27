package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class leetcode46 {


    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        HS(nums, 0, new ArrayList<>());

        return res;
    }

    private void HS(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            res.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            ArrayList<Integer> list1 = new ArrayList<>(list);
            list1.add(nums[index]);
            HS(nums, index + 1, list1);
            swap(nums, index, i); //复原
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        leetcode46 a = new leetcode46();

        System.out.println(a.permute(new int[]{1, 2, 3}));
    }
}
