package com.leetcode;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class leetcode283 {



    public void moveZeroes(int[] nums) {

       int index = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i]=0;
        }

    }

    public void moveZeroes1(int[] nums) {

        boolean flag = false;
        for (int i = 0; i < nums.length - 1 && !flag; i++) {
            flag = true;
            for (int j = 0; j < nums.length-1 - i; j++) {
                if (nums[j] == 0 && nums[j+1] != 0) {
                    int temp = nums[j+1];
                    nums[j+1] = 0;
                    nums[j] = temp;
                    flag = false;
                }
            }
        }

    }
}
