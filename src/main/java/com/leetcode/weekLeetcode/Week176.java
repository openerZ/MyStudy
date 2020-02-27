package com.leetcode.weekLeetcode;

import java.util.*;

public class Week176 {

    public int countNegatives(int[][] grid) {
        int res = 0;
        int colL = grid[0].length;
        int row = grid.length - 1, cols = 0;
        while (row >= 0 && cols < colL) {
            if (grid[row][cols] < 0) {
                res += (colL - cols);
                row--;
            } else {
                cols++;
            }
        }
        return res;
    }

    /********************************************/
    List<Integer> preResult;
    int lastZero;

    /*public ProductOfNumbers() {
        preResult = new ArrayList<>();
        preResult.add(1);
    }*/

    /***
     * 前缀积问题
     * @param num
     */
    public void add(int num) {
        if (num == 0) {
            lastZero = preResult.size();
            preResult.add(1);
        } else {
            preResult.add(preResult.get(preResult.size() - 1) * num);
        }

    }

    public int getProduct(int k) {
        int r = preResult.size() - 1;
        int l = r - k;
        if (l < lastZero) return 0;
        return preResult.get(r) / preResult.get(l);
    }

    /********************************************/

    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int[] arr = new int[events[events.length - 1][1] + 1];
        for (int i = 0; i < events.length; i++) {
            int begin = events[i][0];
            int end = events[i][1];
            for (int j = begin; j <= end; j++) {
                if (arr[j] != 1) {
                    arr[j] = 1;
                    break;
                }
            }
        }
        int res = 0;
        for (int i : arr) {
            if (i > 0) {
                res++;
            }
        }
        return res;


    }

    /********************************************/


    /***
     * 给你一个整数数组 target 。一开始，你有一个数组 A ，它的所有元素均为 1 ，你可以执行以下操作：
     *
     * 令 x 为你数组里所有元素的和
     * 选择满足 0 <= i < target.size 的任意下标 i ，并让 A 数组里下标为 i 处的值为 x 。
     * 你可以重复该过程任意次
     * 如果能从 A 开始构造出目标数组 target ，请你返回 True ，否则返回 False 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：target = [9,3,5]
     * 输出：true
     * 解释：从 [1, 1, 1] 开始
     * [1, 1, 1], 和为 3 ，选择下标 1
     * [1, 3, 1], 和为 5， 选择下标 2
     * [1, 3, 5], 和为 9， 选择下标 0
     * [9, 3, 5] 完成
     * 示例 2：
     *
     * 输入：target = [1,1,1,2]
     * 输出：false
     * 解释：不可能从 [1,1,1,1] 出发构造目标数组。
     *
     * 链接：https://leetcode-cn.com/problems/construct-target-array-with-multiple-sums
     */

    /**
     *倒序求解：
     *      我们把target能否变成全是1的数组
     *      从最大值下手，最大值是上一次数组的和preSum，所以最大值原来的值就是target[i]-(sum-target[i])
     *      1.把数组放入最大堆中，求和sum
     *      2.弹出最大值求上一次该位置的值（逐步退化求解），更新sum，把i处的新值放入最大堆中
     *      3.重复2步骤，如果最大值是1则成功
     *
     */
    public boolean isPossible(int[] target) {

        long sum = 0;
        //构建最大堆
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i : target) {
            sum+=i;
            queue.offer(i);
        }
        if (sum>Integer.MAX_VALUE) return false;
        sum = (int)sum;
        Integer poll;
        while (!queue.isEmpty()&&queue.peek()!=1){
            poll = queue.poll();
            int old = (int) (poll-(sum-poll));
            //如果出现小于1代表不能推出
            if (old<1) return false;
            sum = sum-poll+old;
            queue.offer(old);
        }
        return true;


    }


}
