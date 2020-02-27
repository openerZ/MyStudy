package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class leetcode118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) { //控制行数
            ArrayList<Integer> nl = new ArrayList<>();
            nl.add(1);
            for (int j=1;j<i-1;j++){
                    nl.add(list.get(j-1)+list.get(j));
            }
            if (i>1){
                nl.add(1);
            }
            res.add(nl);
            list=nl;
        }
        return res;
    }
}
