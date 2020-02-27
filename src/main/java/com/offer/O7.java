package com.offer;

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class O7 {

    /**
     * 这样时间复杂度为O(N)
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {

        if (array==null ||array.length==0)return 0;
        int length = array.length;
        for (int i=0;i<length-1;i++){
            if (array[i]>array[i+1]){
                return array[i+1];
            }
        }

        return array[0];
    }

    /**
     * 采用二分搜索将时间复杂度降为O(logN)
     *
     * @return
     */
    public int minNumberInRotateArray1(int[] nums) {
        if (nums.length == 0)
            return 0;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[l] == nums[m] && nums[m] == nums[h])
                return minNumber(nums, l, h);
            else if (nums[m] <= nums[h])
                h = m;
            else
                l = m + 1;
        }
        return nums[l];
    }

    private int minNumber(int[] nums, int l, int h) {
        for (int i = l; i < h; i++)
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        return nums[l];
    }

}
