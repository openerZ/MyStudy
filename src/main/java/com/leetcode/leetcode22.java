package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class leetcode22 {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return res;
        DG(n,n,new StringBuilder());
        return res;
    }

    private void DG(int left, int right,  StringBuilder str) {
        if (left > right) return; //不符合的直接返回
        if (left == 0 && right == 0) { //终止条件
             res.add(str.toString());
            return;
        }
        if (left == 0 && right > 0) {
            while (right>0){
                right--;
                str.append(')');
            }
            res.add(str.toString());
            return;
        }
        //回溯遍历
        DG(left - 1, right,  new StringBuilder(str).append('('));
        DG(left, right - 1, new StringBuilder(str).append(')'));
    }

    public static void main(String[] args) {
        leetcode22 l = new leetcode22();
        System.out.println(l.generateParenthesis(4));
    }
}
