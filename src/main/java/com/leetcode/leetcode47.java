package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class leetcode47 {


    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
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

        //剔除重复的数
//        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            /*if (set.contains(nums[i])){
                continue;
            }else {
                set.add(nums[i]);
            }*/
            if (isSwap(nums, index, i)) {
                swap(nums, index, i);
                ArrayList<Integer> list1 = new ArrayList<>(list);
                list1.add(nums[index]);
                HS(nums, index + 1, list1);
                swap(nums, index, i); //复原
            }
        }
    }

    //检查是否交换过
    private boolean isSwap(int[] nums, int begin, int end) {
        for (int i = begin; i < end; i++) {
            if (nums[i] == nums[end]) {
                return false;
            }

        }
        return true;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        leetcode47 a = new leetcode47();

        System.out.println(a.permuteUnique(new int[]{1, 2, 3}));
    }
}
