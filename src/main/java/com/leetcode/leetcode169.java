package com.leetcode;

import java.util.Arrays;

public class leetcode169 {

    public int majorityElement(int[] nums) {

        int count=1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count==0){
                count=1;
                res = nums[i];
                continue;
            }
            if (nums[i]==res){
                count++;
            }else {
                count--;
            }
        }
        return res;
    }
}
