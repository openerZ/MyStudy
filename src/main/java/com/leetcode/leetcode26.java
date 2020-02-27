package com.leetcode;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class leetcode26 {

    /**
     * 采用双指针：
     * p指向第一个元素，q指向第二元素
     * （1）比较平p,q上的元素，
     * （2）如果相等移动q++，重复（1）
     * （3）如果不等把p的下一个元素 赋值成q所在元素，然后p,q都移动一个位置在重复（1）
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length==0) return 0;
        int length = nums.length;
        int p = 0, q = 1;
        while (q < length) {
            if (nums[p] != nums[q]) {
                nums[++p] = nums[q];
            }
            q++;
        }
        return p + 1;
    }
}
