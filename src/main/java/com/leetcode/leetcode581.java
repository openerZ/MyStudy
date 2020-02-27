package com.leetcode;

import org.omg.CORBA.MARSHAL;

/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 你找到的子数组应是最短的，请输出它的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 * <p>
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode581 {

    /**
     * 从左到右循环，记录最大值为 max，若 nums[i] < max, 则表明位置 i 需要调整, 循环结束，
     * 记录需要调整的最大位置 i 为 high;
     * 同理，从右到左循环，记录最小值为 min,若 nums[i] > min, 则表明位置 i 需要调整，循环结束
     * ，记录需要调整的最小位置 i 为 low.
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int min = nums[n - 1];
        int low = n - 1;
        //从右向左遍历，如果当前nums[i]得值大于min值，则需要排序 ，记录下来
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > min) {
                low = i;
            }
            min = Math.min(min, nums[i]);
        }
        int max = nums[0];
        int high = 0;
        //从左向右遍历，如果当前nums[i]的值小于之前的数组的最大值，当前位置就需要进行排序，记录下来
        for (int i = 1; i < n; i++) {
            if (nums[i] < max) {
                high = i;
            }
            max = Math.max(max, nums[i]);
        }

        return high > low ? high - low + 1 : 0;

    }
}
