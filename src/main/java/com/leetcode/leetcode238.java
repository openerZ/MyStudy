package com.leetcode;

/**
 *
 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。



 示例:

 输入: [1,2,3,4]
 输出: [24,12,8,6]


 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

 进阶：
 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class leetcode238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] pre = new int[n];
        int[] ord = new int[n];
        pre[0] = 1;
        ord[n-1]=1;
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i-1]*pre[i-1];
            ord[n-1-i] = nums[n-i]*ord[n-i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = pre[i]*ord[i];
        }

        return res;
    }
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int left=1,right=1;
        //先算左边的乘积
        for (int i = 0; i < n; i++) {
            res[i]=left;
            left *=nums[i];
        }
        //在算右边的乘积
        for (int i = n-1; i >=0 ; i--) {
            res[i]*=right;
            right*=nums[i];
        }
        return res;
    }
}
