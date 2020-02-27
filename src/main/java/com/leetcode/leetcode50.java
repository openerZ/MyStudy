package com.leetcode;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class leetcode50 {
    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow1(x, n / 2);
        double rest = myPow1(x, n % 2);
        return half * half * rest;
    }

    public double myPow(double x, int n) {
        //防止溢出
        long N=n;
        if (N<0){
            x=1/x;
            N=-N;
        }
        return fastPow(x,N);
    }

    private double fastPow(double x,long n){
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if ((n&1)==0){ //偶数
            return fastPow(x*x,n/2);
        }else { //奇数
            return x*fastPow(x*x,n/2);
        }
    }

    public static void main(String[] args) {
        leetcode50 a = new leetcode50();
        System.out.println(a.myPow(-0.2,3));
    }
}
