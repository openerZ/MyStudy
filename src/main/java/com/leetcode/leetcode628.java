package com.leetcode;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 */
public class leetcode628 {

    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num>max1){
                max3 =max2;
                max2 = max1;
                max1 =num;
            }else if (num>max2){
                max3 =max2;
                max2 = num;
            }else if (num>max3){
                max3 =num;
            }
            if (num<min1){
                min2 = min1;
                min1 = num;
            }else if (num<min2){
                min2 = num;
            }
        }

        return Math.max(max1*max2*max3,max1*min1*min2);
    }
}
