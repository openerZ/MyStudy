package com.leetcode;

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 */
public class leetcode367 {

    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num % mid == 0 && num / mid == mid) {
                return true;
            } else if (num / mid > mid) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }
        return false;

    }

    public boolean isPerfectSquare1(int num) {
        int temp = 1;
        int k = 3;
        while (temp < num) {
            temp += k;
            k += 2;
        }
        return temp == num;
    }
}
