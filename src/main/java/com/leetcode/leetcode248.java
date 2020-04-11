package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 示例 2:
 * <p>
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode248 {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        int pre = nums[0];
        int cur = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] == cur + 1) {
                cur += 1;
            } else {
                if (pre == cur) {
                    res.add(pre + "");
                } else {
                    res.add(pre + "->" + cur);
                }
                pre = nums[i];
                cur = nums[i];
            }

        }
        if (pre == cur) {
            res.add(pre + "");
        } else {
            res.add(pre + "->" + cur);
        }
        return res;

    }

    public List<String> summaryRanges1(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        int l = 0;
        int r = 0;
        while (r < n) {
            while (r<n-1&&nums[r]+1==nums[r+1]){
                r++;
            }
            if (l==r){
                res.add(nums[l]+"");
            }else {
                res.add(nums[l]+"->"+nums[r]);
            }
            r++;
            l=r;
        }
        return res;
    }
}
