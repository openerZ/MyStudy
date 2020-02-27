package com.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class leetcode09 {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int res = 0;
        int a = x;
        //将整数翻转
        while (a != 0) {
            int m = a % 10;
            res = res *10 +m;
            a = a/10;
        }
        return res==x;
    }
}
