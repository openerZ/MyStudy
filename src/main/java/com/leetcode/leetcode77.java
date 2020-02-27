package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class leetcode77 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k>n) return res;
        HS(n,0,k,new ArrayList<>());
        return res;
    }

    private void HS(int n,int index,int k,List<Integer> list){

        if (list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }else if(list.size()>k){
            return;
        }
        for (int i = index; i <n ; i++) {
            list.add(i+1);
            HS(n,i+1,k,list);
            //回溯
            list.remove(list.size()-1);
        }
    }
}
