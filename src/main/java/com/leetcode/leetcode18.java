package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class leetcode18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        //对数组排序
        int length = nums.length;
        Arrays.sort(nums);
        for (int j = 0; j < length; j++) {
            if (j > 0 && nums[j] == nums[j - 1]) continue; //去重
            int a = target - nums[j];
            for (int i = j + 1; i < length; i++) {
                if (i > j + 1 && nums[i] == nums[i - 1]) continue; //去重
                int l = i + 1;
                int r = length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == a) {
                        res.add(Arrays.asList(nums[j], nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++; //去重
                        while (l < r && nums[r] == nums[r - 1]) r--; //去重
                        l++;
                        r--;
                    } else if (sum < a) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] a={1,-2,-5,-4,-3,3,3,5};
        List<List<Integer>> lists = fourSum(a, -11);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }

    }
}
