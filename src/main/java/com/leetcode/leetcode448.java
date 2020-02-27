package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 */
public class leetcode448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                while (nums[i] != i + 1) {
                    int temp = nums[i];
                    if (nums[temp - 1] == temp || nums[temp - 1] == 0) {
                        nums[temp - 1] = temp;
                        nums[i] = 0;
                        break;
                    }
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[Math.abs(nums[i])-1]>0){
                nums[Math.abs(nums[i])-1]=-nums[Math.abs(nums[i])-1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i]>0){
                res.add(i+1);
            }
        }
        return res;
    }
}
