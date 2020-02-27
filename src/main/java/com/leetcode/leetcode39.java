package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class leetcode39 {

    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        Arrays.sort(candidates);
        HS(candidates, target, 0, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void HS(int[] candidates, int target, int left, List<Integer> list, int sum) {

        if (sum > target || (left == candidates.length && target != sum)) return;
        for (int i = left; i < candidates.length; i++) {
            ArrayList<Integer> al = new ArrayList<>(list);
            al.add(candidates[i]);
            if ((sum + candidates[i]) > target) break;
            if (target == (sum + candidates[i])) {
                ans.add(al);
                break;
            }
            HS(candidates, target, i, al, sum + candidates[i]);
        }
    }
}
