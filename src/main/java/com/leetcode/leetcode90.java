package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class leetcode90 {

    private List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length==0) return res;
        Arrays.sort(nums);
        HS(nums,0,new ArrayList<>());
        return res;
    }


    private void HS(int[] nums,int index,List<Integer> list){
        res.add(new ArrayList<>(list));
        for (int i = index; i <nums.length ; i++) {
            if (i>index&&nums[i-1]==nums[i]) continue; //去重
            list.add(nums[i]);
            HS(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }
}
