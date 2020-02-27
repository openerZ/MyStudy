package com.leetcode;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class leetcode69 {

    public int mySqrt(int x) {
        if (x <= 1) return x;
        int left = 0, right = x/2+1;
        //因为left和right没有逼近，所以left+1<right
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            //使用除法防止溢出
            if (mid <= (x / mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;

    }

    /**
     * 由f(x)=x^2-a 当x^2-a=0时x为解
     * 由牛顿迭代法
     *  x-f(x)/f'(x)=(x+a/x)/2
     */
    public int mySqrt1(int x) {
        if(x==0) return 0;
        double t=x;
        while (t*t>x ){
            t = (t + x /t) / 2;
        }
        return (int) t;
    }




    public static void main(String[] args) {
        leetcode69 a = new leetcode69();
        System.out.println(a.mySqrt(6));

    }
}
