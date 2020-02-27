package com.leetcode;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class leetcode287 {


    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                fast = 0;
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return fast;
            }
        }
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = ((1 + n) * n) / 2;
        for (int num : nums) {
            res -= num;
        }
        return res;
    }

    public int missingNumber1(int[] nums) {

        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= (i ^ nums[i]);
        }
        return res;
    }

    //leetcode645. 错误的集合
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        res[0] = 0;
        boolean flag = true;
        for (int i = 0; i < nums.length && flag; i++) {
            if (nums[i] != i + 1) {
                while (nums[i] != i + 1) {
                    int temp = nums[i] - 1;
                    if (nums[temp] == temp + 1) {
                        res[0] = temp + 1;
                        flag = false;
                        break;
                    } else {
                        nums[i] = nums[temp];
                        nums[temp] = temp + 1;
                    }
                }
            }
        }
        res[1] = res[0];
        for (int i = 0; i < nums.length; i++) {
            res[1] ^= ((i + 1) ^ nums[i]);
        }
        return res;
    }
    public int[] findErrorNums1(int[] nums) {
        int[] temp = new int[nums.length+1];
        int[] res = new int[2];
        for (int num : nums) {
            if (temp[num]==-1){
                res[0] = num;
            }else {
                temp[num]=-1;
            }
        }
        for (int i = 1; i < temp.length; i++) {
            if (temp[i]==0){
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
