package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class leetcode57 {

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            list.add(new int[]{newInterval[0], newInterval[1]});
            return list.toArray(new int[list.size()][2]);
        }
        int len = intervals.length;
        boolean falg = true;
        int k = 1;
        int left = intervals[0][0], right = intervals[0][1];
        int p = newInterval[0], q = newInterval[1];
        if (q < left) {
            list.add(new int[]{p, q});
            falg = false;
        } else if (p >= left && p <= right && q > right) {
            right = q;
            falg = false;
        } else if (p <= left && q >= right) {
            left = p;
            right = q;
            falg = false;
        } else if (q <= right && p < left) {
            left = p;
            falg = false;
        } else if (p >= left && q <= right) {
            falg = false;
        }
        while (k < len) {
            int k0 = intervals[k][0];
            int k1 = intervals[k][1];
            if (falg) {
                if (p > right && q < k0) {
                    list.add(new int[]{left, right});
                    left = p;
                    right = q;
                    falg = false;
                } else if (p >= left && p <= right && q > right) {
                    right = q;
                    falg = false;
                } else if (p <= left && q >= right) {
                    left = p;
                    right = q;
                    falg = false;
                } else if (q <= right && p < left) {
                    left = p;
                    falg = false;
                } else if (p >= left && q <= right) {
                    falg = false;
                }
            }
            if (right >= k0) {
                if (right < k1) {
                    right = k1;
                }
            } else {
                list.add(new int[]{left, right});
                left = k0;
                right = k1;
            }
            k++;
        }
        if (falg) {
            if (p >= left && p <= right && q > right) {
                right = q;
            } else if (p <= left && q >= right) {
                left = p;
                right = q;
            } else if (q <= right && p < left) {
                left = p;
            } else if (p > right) {
                list.add(new int[]{left, right});
                left = p;
                right = q;
            } else if (q < left) {
                list.add(new int[]{p, q});
            }
        }
        list.add(new int[]{left, right});
        return list.toArray(new int[list.size()][2]);
    }

    /**
     * 贪心算法：从最简单的子结构开始拆分
     * 1.当interval整体在newInterval整体之前时：List<int[]> res直接添加interval整体，并将插入位置insertPos+1；
     * 2.当interval整体在newInterval整体之后时：说明此时newInterval已经添加☞List<int[]> res中，直接添加interval整体；
     * 3.interval与newInterval存在相交的情况，(不用分析有几个interval与newInterval相交了)，只要相交了，将interval与newInterval融合：
     * 1.newInterval[0] = Math.min(interval[0], newInterval[0]);
     * 2.newInterval[1] = Math.max(interval[1], newInterval[1]);
     * 4.最后遍历完interval，将newInterval插入到res指定的位置insertPos；
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || intervals == null) {
            return intervals;
        }

        List<int[]> results = new ArrayList<int[]>();
        int insertPos = 0;//插入位置

        for (int[] interval : intervals) {//遍历intervals
            if (interval[1] < newInterval[0]) {//如果当前区间的end小于新区间的start，说明无重叠，直接添加
                results.add(new int[]{interval[0], interval[1]});
                insertPos++;//插入位置+1
            } else if (interval[0] > newInterval[1]) {//如果当前区间的start大于新区间的end，说明无重叠，直接添加
                results.add(new int[]{interval[0], interval[1]});
            } else {//否则一定有重叠，取两个区间的最小start，和最大end, 作为新区间
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        results.add(insertPos, new int[]{newInterval[0], newInterval[1]});

        return results.toArray(new int[results.size()][2]);
    }

}
