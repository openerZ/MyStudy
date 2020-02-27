package com.offer;

/**
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * <p>
 * 保证base和exponent不同时为0
 */
public class O13 {


    /**
     * 递归调用：每次把指数缩减一半
     * 因为 (x*x)n/2 可以通过递归求解，并且每次递归 n 都减小一半，因此整个算法的时间复杂度为 O(logN)
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (base == 0.0) return 0;
        if (exponent == 0) return 1;

        if (exponent % 2 == 0) {  //指数为偶数时
            return Power(base * base, exponent / 2);
        } else { //指数为奇数时
            if (exponent > 0) {  //为正数
                return base * Power(base * base, exponent / 2);
            } else { //为负数
                return 1 / base * Power(base * base, exponent / 2);
            }
        }

    }

    public static void main(String[] args) {
        O13 o13 = new O13();
        System.out.println(o13.Power(-2.0, -4));

    }
}
