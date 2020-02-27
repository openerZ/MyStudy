package com.leetcode;

import java.util.Arrays;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class leetcode27 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0, q = 1;
        while (q < nums.length) {
            if (nums[p] == val) {
                nums[p] = nums[q];
            } else {
                nums[++p] = nums[q];
            }
            q++;
        }
        //删除的元素可能在最后
        if (nums[p]==val){
            p--;
        }
        return p+1;
    }

    /**
     * 拷贝覆盖
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
       int index=0;
        for (int num : nums) {
            if (num!=val){
                nums[index++] = num;
            }
        }
        return index;
    }

    public int removeElement3(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

}
