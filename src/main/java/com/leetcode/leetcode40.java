package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class leetcode40 {

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
            if (i > left && candidates[i - 1] == candidates[i]) continue; //去重
            ArrayList<Integer> al = new ArrayList<>(list);
            al.add(candidates[i]);
            if ((sum + candidates[i]) > target) break;
            if (target == (sum + candidates[i])) {
                ans.add(al);
                break;
            }
            HS(candidates, target, i + 1, al, sum + candidates[i]);
        }
    }
}
