package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class leetcode119 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) { //控制行数
            ArrayList<Integer> nl = new ArrayList<>();
            nl.add(1);
            for (int j = 1; j < i - 1; j++) {
                nl.add(list.get(j - 1) + list.get(j));
            }
            if (i > 1) {
                nl.add(1);
            }
            res.add(nl);
            list = nl;
        }
        return res;
    }

    public List<Integer> getRow(int rowIndex) {

        Integer[] arr = new Integer[rowIndex + 1];
        arr[0] = 1;
        for (int i = 1; i <= rowIndex + 1; i++) { //控制行数
            int pre = 0;
            int k = 1;
            for (int j = 1; j < i; j++) {
                if (j == i - 1) {
                    arr[j] = 1;
                } else {
                    pre = arr[j];
                    arr[j] = arr[j] + k;
                    k = pre;
                }

            }
        }
        List<Integer> res = Arrays.asList(arr);
        return res;
    }

    public List<Integer> getRow1(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <=rowIndex ; i++) {
            for (int j = i-1; j>0 ; j--) { //到序求和，防止覆盖
                list.set(j,list.get(j)+list.get(j-1));
            }
            //每行尾部是0；
            list.add(1);
        }

        return list;
    }
}
