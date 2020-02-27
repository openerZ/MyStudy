package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class leetcode56 {

    public int[][] merge(int[][] intervals) {
        if (intervals==null||intervals.length<=1) return intervals;
        int len = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int k=1;
        int left=intervals[0][0],right=intervals[0][1];
        ArrayList<Integer> list = new ArrayList<>();
        while (k<len){
            if (right>=intervals[k][0]){
                if (right<intervals[k][1]){
                    right=intervals[k][1];
                }
            }else {
                list.add(left);
                list.add(right);
                left=intervals[k][0];
                right=intervals[k][1];
            }
            k++;
        }
        list.add(left);
        list.add(right);

        int[][] res = new int[list.size()/2][2];
        int index=0;
        int t=0;
        while (t<list.size()){
            res[index][0]=list.get(t++);
            res[index++][1]=list.get(t++);
        }
        return res;
    }
    public int[][] merge1(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;
        int len = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int k = 1;
        int left = intervals[0][0], right = intervals[0][1];
        ArrayList<int[]> list = new ArrayList<>();
        while (k < len) {
            if (right >= intervals[k][0]) {
                if (right < intervals[k][1]) {
                    right = intervals[k][1];
                }
            } else {
                list.add(new int[]{left, right});
                left = intervals[k][0];
                right = intervals[k][1];
            }
            k++;
        }
        list.add(new int[]{left, right});
        return list.toArray(new int[list.size()][2]);
    }
}
