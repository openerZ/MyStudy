package com.leetcode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 */
public class leetcode45 {

    /**
     * 贪心策略
     *我们在跳的时候会考虑到下一步。根据下一步能跳的最远的贪心策略，来进行每一步的选择。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {

        int ans = 0;
        //此次跳跃的边界
        int endindex = 0;
        //动态更新下一次跳跃的最远点
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //一直更新到当前边界之前，求出的当前的跳跃+下一次跳跃最远的距离
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == endindex) {
                endindex = maxPosition;
                ans++;
            }
        }

        return ans;
    }
}
