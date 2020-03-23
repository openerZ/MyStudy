package com.leetcode;

/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode540 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0,r = nums.length-1;
        while (l<r){
            int m = l+(r-l)/2;
            if (m%2==1){
                m--;
            }
            if (nums[m]==nums[m+1]){
                l=m+2;
            }else {
                r=m;
            }
        }
        return nums[l];
    }
}
