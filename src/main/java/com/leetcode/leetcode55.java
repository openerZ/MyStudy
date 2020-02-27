package com.leetcode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class leetcode55 {


    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length <= 1) return true;

        int length = nums.length;
        boolean[] dp = new boolean[length];
        dp[length - 1] = true;
        for (int i = length - 2; i >= 0; i--) {
            dp[i] = false;
            //遍历i位置所能跳的j范围内能不能有条路
            for (int j = i + 1; j <= i + nums[i] && j < length; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) return true;
        int length = nums.length;
        //离当前位置最近的可达路径.存的是下标位置
        int right = length - 1;
        for (int i = length - 2; i >= 0; i--) {
          if (i+nums[i]>=right){
              right=i;
          }
        }
        return right==0;
    }

    /**
     * 计算所能达到最大的距离
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length <= 1) return true;
        //max是在i之前的位置（包括i）所能走到最大的位置
        int max=nums[0];

        for (int i = 1; i < nums.length; i++) {
            //如果未到前边范围的最大值那么更新
            if (i<=max){
                max = Math.max(nums[i]+i,max);
            }else { //如果前面无论怎磨走都到达不了此位置那么永远到不了
                return false;
            }
        }
        return max>=nums.length-1;
    }
}
