package com.leetcode;

import java.util.HashSet;

public class leetcode128 {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int cnt = 0;
                while (set.contains(num)) {
                    cnt++;
                    num++;
                }
                res = Math.max(cnt,res);
            }
        }
        return res;
    }
}
