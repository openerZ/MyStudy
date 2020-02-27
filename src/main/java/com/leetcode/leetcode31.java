package com.leetcode;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class leetcode31 {

    public void nextPermutation(int[] nums) {
        if (nums==null||nums.length==0) return;

        int index  = nums.length-1;

        while (index>0){
            //找到第一对的升序对
            if (nums[index]>nums[index-1]){
                int temp = nums[index];
                int j=index;
                int i=index;
                //在降序的后面找到最接近大于他（index-1）的进行交换
                while (j<nums.length){
                    if (nums[j]<=temp &&nums[j]>nums[index-1]){
                        temp=nums[j];
                        i=j;
                    }
                    j++;
                }
                //交换
                nums[i]=nums[index-1];
                nums[index-1]=temp;
                //剩下的排序
                Arrays.sort(nums,index,nums.length);
                return;
            }
            index--;
        }
        Arrays.sort(nums);
    }
}
